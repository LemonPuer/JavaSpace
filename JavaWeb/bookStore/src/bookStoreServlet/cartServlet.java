package bookStoreServlet;

import DAO.Book.Book;
import DAO.Cart.Cart;
import DAO.Cart.CartItem;
import DAO.Tool;
import Service.Book.BService;
import Service.Book.BServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Lemon
 * @create 2022-10-30-20:27
 */
public class cartServlet extends baseServlet{
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BService bs=new BServiceImpl();
        int id = Tool.parseInt(req.getParameter("id"), 0);
        Book book = bs.queryBookById(id);
        req.getSession().setAttribute("lastName",book.getName());
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice()));
//        req.getSession().setAttribute("cart",cart);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Tool.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        cart.deleteItem(id);
//        req.getSession().setAttribute("cart",cart);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        cart.clear();
//        req.getSession().setAttribute("cart",cart);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Tool.parseInt(req.getParameter("id"),0);
        int count = Tool.parseInt(req.getParameter("count"),1);
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        cart.update(id,count);
//        req.getSession().setAttribute("cart",cart);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
