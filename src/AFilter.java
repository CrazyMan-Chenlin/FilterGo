import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AFilter",urlPatterns = "/ChainServlet")
public class AFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("1)第一个过滤器处理request任务");
        chain.doFilter(req, resp);
        System.out.println("5)第一个过滤器处理response任务");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
