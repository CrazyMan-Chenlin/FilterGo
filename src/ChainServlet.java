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
        System.out.println("3)��ȡ��ChainServlet");
        response.setCharacterEncoding("GBK");
       response.getWriter().write("ʹ��ע�ⷽʽд����������ͬweb.xml��д������������˳����ǹ����������֣�" +
               "����AFilter����������BFilter����������request" +
               "BFilter����������AFilter����response");
    }
}
