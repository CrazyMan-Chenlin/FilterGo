import java.io.IOException;

@javax.servlet.annotation.WebFilter(filterName = "FirstFilter" ,urlPatterns = "/targetServlet")
public class FirstFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        System.out.println("3)过滤器正在过滤请求");
        //该方法为放行请求与响应
        chain.doFilter(req,resp);
        System.out.println("5)过滤器正在过滤响应");
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {
        System.out.println("2)过滤器初始方法");
    }

}
