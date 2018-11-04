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
       //强转成构造函数中的response对象
        HttpServletResponse response=(HttpServletResponse)resp;
        MyResponse myResponse=new MyResponse(response);
        chain.doFilter(req, myResponse);
        //过滤响应
        char[] content = myResponse.getCharArray();
        ByteArrayOutputStream byteArr=new ByteArrayOutputStream();
        //创建Gzip对象
        GZIPOutputStream gzip=new GZIPOutputStream(byteArr);
        //开始写入压缩内容
        gzip.write(new String(content).getBytes());
        //刷新缓存.       *将内容真正写入数组中
        gzip.finish();
        //从临时字节数组中得到缓存的内容
        byte[] result=byteArr.toByteArray();
        //注意：告诉浏览器数据压缩格式  发送响应头：content-encoding:gzip
        myResponse.setHeader("content-encoding","gzip");
        //输出到浏览器
        response.getOutputStream().write(result);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
  class MyResponse extends HttpServletResponseWrapper {
      //装饰者模式就是在原有的基础上，进行封装,所以是继承关系
      HttpServletResponse reponse;
      CharArrayWriter caw=new CharArrayWriter(); //构建一个可用作Writer的字符缓冲区
      public MyResponse(HttpServletResponse response) {
          super(response);
          this.reponse=response;
      }
      //get实体内容
      public char [] getCharArray(){
          return caw.toCharArray();
      }
     //重写getWriter方式来建立一个缓冲区，可以获取网页内容
      @Override
      public PrintWriter getWriter() throws IOException {
          PrintWriter pw=new PrintWriter(caw);    //将缓冲区放入到pw中
          return pw;
      }
  }