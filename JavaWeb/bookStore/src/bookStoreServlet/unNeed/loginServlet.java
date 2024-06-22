package bookStoreServlet.unNeed;

import DAO.BUser.BUser;
import DAO.BUser.BUserDAOimpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Lemon
 * @create 2022-10-22-8:40
 */
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        BUserDAOimpl bud=new BUserDAOimpl();
        BUser bUser = bud.selectByNAP(name, password);
        if(bUser==null){
            System.out.println("账号或密码错误!");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
