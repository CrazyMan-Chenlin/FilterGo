

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("roy".equals(username)&&"123456".equals(password)){
            HttpSession session= request.getSession(true); //true 代表如果当前没有新的session，会创建一个新的session
            //保存到session域中
            session.setAttribute("username",username);
            //转回到用户主页中
            request.getRequestDispatcher("/user/index.jsp").forward(request,response);
        }else {
              //登录失败
            String message="账号密码错误";
            request.setAttribute("msg",message);
             request.getRequestDispatcher("login2.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
