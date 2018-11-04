import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "BFilter",urlPatterns = "/ChainServlet")
public class BFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("2)第二个过滤器处理request任务");
        chain.doFilter(req, resp);
        System.out.println("4)第二个过滤器处理response任务");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
