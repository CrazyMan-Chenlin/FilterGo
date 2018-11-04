import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChainServlet",urlPatterns = "/ChainServlet")
public class ChainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("3)获取到ChainServlet");
        response.setCharacterEncoding("GBK");
       response.getWriter().write("使用注解方式写过滤链，不同web.xml上写，决定过滤器顺序的是过滤器的名字，" +
               "例如AFilter过滤器先于BFilter过滤器处理request" +
               "BFilter过滤器先于AFilter处理response");
    }
}
