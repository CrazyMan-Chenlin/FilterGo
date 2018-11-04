import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebFilter(filterName = "EncodingFilter",urlPatterns = "/*")
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       //使用装饰者模式来修改getParameter方法
        HttpServletRequest request=(HttpServletRequest)req;
        //request.setCharacterEncoding("GBK");
        MyRequest myRequest=new MyRequest(request);
        chain.doFilter(myRequest, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
  class MyRequest extends HttpServletRequestWrapper{
         HttpServletRequest request;
      public MyRequest(HttpServletRequest request) {
          super(request);
          this.request=request;
      }
      @Override
      public String getParameter(String name) {
          try {
              String str=request.getParameter(name);
              if (this.request.getMethod().equals("GET")) {
                  request.setCharacterEncoding("UTF-8");
                  System.out.println(str);
              }
              return str;
          } catch (UnsupportedEncodingException e) {
              e.printStackTrace();
              throw new RuntimeException();
          }

      }

  }