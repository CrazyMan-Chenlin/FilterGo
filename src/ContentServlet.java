import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

@WebServlet(name = "ContentServlet",urlPatterns = "/ContentServlet")
public class ContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          StringBuffer sb=new StringBuffer();
        for (int i = 0; i <=3000; i++) {
            sb.append("abcd");
        }
        System.out.println("ѹ��ǰ�Ĵ�С:"+sb.toString().getBytes().length+"Byte");
        //t1(response, sb);

        //����������
        response.getWriter().write(sb.toString());

    }

    private void t1(HttpServletResponse response, StringBuffer sb) throws IOException {
        //������ʱ���ֽ���������
        ByteArrayOutputStream byteArr=new ByteArrayOutputStream();
        //����Gzip����
        GZIPOutputStream gzip=new GZIPOutputStream(byteArr);
        //��ʼд��ѹ������
        gzip.write(sb.toString().getBytes());
        //ˢ�»���.       *����������д��������
        gzip.finish();
        //����ʱ�ֽ������еõ����������
        byte[] result=byteArr.toByteArray();
        System.out.println("ѹ����Ĵ�С:"+result.length+"Byte");
        //ע�⣺�������������ѹ����ʽ  ������Ӧͷ��content-encoding:gzip
        response.setHeader("content-encoding","gzip");
        //����������
        response.getOutputStream().write(result);
    }
}
