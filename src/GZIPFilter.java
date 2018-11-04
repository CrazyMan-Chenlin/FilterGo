import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

@WebFilter(filterName = "GZIPFilter",urlPatterns ="/*")
public class GZIPFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       //ǿת�ɹ��캯���е�response����
        HttpServletResponse response=(HttpServletResponse)resp;
        MyResponse myResponse=new MyResponse(response);
        chain.doFilter(req, myResponse);
        //������Ӧ
        char[] content = myResponse.getCharArray();
        ByteArrayOutputStream byteArr=new ByteArrayOutputStream();
        //����Gzip����
        GZIPOutputStream gzip=new GZIPOutputStream(byteArr);
        //��ʼд��ѹ������
        gzip.write(new String(content).getBytes());
        //ˢ�»���.       *����������д��������
        gzip.finish();
        //����ʱ�ֽ������еõ����������
        byte[] result=byteArr.toByteArray();
        //ע�⣺�������������ѹ����ʽ  ������Ӧͷ��content-encoding:gzip
        myResponse.setHeader("content-encoding","gzip");
        //����������
        response.getOutputStream().write(result);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
  class MyResponse extends HttpServletResponseWrapper {
      //װ����ģʽ������ԭ�еĻ����ϣ����з�װ,�����Ǽ̳й�ϵ
      HttpServletResponse reponse;
      CharArrayWriter caw=new CharArrayWriter(); //����һ��������Writer���ַ�������
      public MyResponse(HttpServletResponse response) {
          super(response);
          this.reponse=response;
      }
      //getʵ������
      public char [] getCharArray(){
          return caw.toCharArray();
      }
     //��дgetWriter��ʽ������һ�������������Ի�ȡ��ҳ����
      @Override
      public PrintWriter getWriter() throws IOException {
          PrintWriter pw=new PrintWriter(caw);    //�����������뵽pw��
          return pw;
      }
  }