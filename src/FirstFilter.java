import java.io.IOException;

@javax.servlet.annotation.WebFilter(filterName = "FirstFilter" ,urlPatterns = "/targetServlet")
public class FirstFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        System.out.println("3)���������ڹ�������");
        //�÷���Ϊ������������Ӧ
        chain.doFilter(req,resp);
        System.out.println("5)���������ڹ�����Ӧ");
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {
        System.out.println("2)��������ʼ����");
    }

}
