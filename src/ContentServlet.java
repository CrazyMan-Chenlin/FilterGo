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
        System.out.println("压缩前的大小:"+sb.toString().getBytes().length+"Byte");
        //t1(response, sb);

        //输出到浏览器
        response.getWriter().write(sb.toString());

    }

    private void t1(HttpServletResponse response, StringBuffer sb) throws IOException {
        //创建临时的字节数组容器
        ByteArrayOutputStream byteArr=new ByteArrayOutputStream();
        //创建Gzip对象
        GZIPOutputStream gzip=new GZIPOutputStream(byteArr);
        //开始写入压缩内容
        gzip.write(sb.toString().getBytes());
        //刷新缓存.       *将内容真正写入数组中
        gzip.finish();
        //从临时字节数组中得到缓存的内容
        byte[] result=byteArr.toByteArray();
        System.out.println("压缩后的大小:"+result.length+"Byte");
        //注意：告诉浏览器数据压缩格式  发送响应头：content-encoding:gzip
        response.setHeader("content-encoding","gzip");
        //输出到浏览器
        response.getOutputStream().write(result);
    }
}
