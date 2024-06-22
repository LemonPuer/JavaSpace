package bookStoreServlet;

import DAO.BUser.BUser;
import Service.BUser.UService;
import Service.BUser.UServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author Lemon
 * @create 2022-10-23-17:28
 */
public class userServlet extends baseServlet {
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        UService us = new UServiceImpl();
        BUser bUser = us.selectByNAP(name, password);
        if (bUser == null) {
            req.setAttribute("msg", "用户名或密码错误!");
            req.setAttribute("name", name);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("name",name);
            req.getSession().setAttribute("userId",bUser.getId());
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String attribute = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        UService us = new UServiceImpl();
        boolean exists = us.isExists(name);
        if (attribute.equalsIgnoreCase(code)) {
            if (exists) {
                req.setAttribute("msg", "用户已存在!");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                us.saveBuser(name, password, email);
                req.getSession().setAttribute("name",name);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg", "验证码错误!");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
