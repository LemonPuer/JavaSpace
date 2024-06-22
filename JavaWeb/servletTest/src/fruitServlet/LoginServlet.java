package fruitServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Lemon
 * @create 2022-10-29-15:04
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Cookie[] cookies = req.getCookies();
        if ("John".equals(name) && "John".equals(password)) {
            resp.getWriter().write("成功登录!");
            resp.addCookie(new Cookie("name", "John"));
        }
        for (Cookie c : cookies) {
            System.out.println(c.getName() + "=" + c.getValue());
        }
    }
}

