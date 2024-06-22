package selCus;

import DAO.Customer;
import DAO.CustomerDAOimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-19-9:28
 */
public class CusList extends ViewBaseServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDAOimpl cdi=new CustomerDAOimpl();
        List<Customer> list = cdi.getAll();
        HttpSession session = req.getSession();
        session.setAttribute("List",list);
        super.processTemplate("selectCus",req,resp);
    }
}
