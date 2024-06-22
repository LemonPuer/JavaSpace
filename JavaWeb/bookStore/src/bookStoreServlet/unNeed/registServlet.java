package bookStoreServlet.unNeed;

import DAO.BUser.BUserDAOimpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Lemon
 * @create 2022-10-22-9:07
 */
public class registServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        BUserDAOimpl bud = new BUserDAOimpl();
        boolean exists = bud.isExists(name);
        if ("abcde".equalsIgnoreCase(code)) {
            if (exists) {
                System.out.println("用户已存在!");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                bud.saveBuser(name, password, email);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            System.out.println("验证码错误!");
        }
    }
}
