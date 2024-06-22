package bookStoreServlet;

import DAO.Book.Book;
import DAO.Cart.Cart;
import DAO.Cart.CartItem;
import DAO.Tool;
import Service.BUser.UService;
import Service.BUser.UServiceImpl;
import Service.Book.BService;
import Service.Book.BServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lemon
 * @create 2022-11-03-15:22
 */
public class ajaxServlet extends baseServlet{
    public void check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson=new Gson();
        String name = req.getParameter("username");
        UService us = new UServiceImpl();
        boolean exists = us.isExists(name);
        Map<String,Boolean> map=new HashMap<>();
        map.put("a",exists);
        resp.getWriter().write(gson.toJson(map));
    }
    public void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Tool.parseInt(req.getParameter("id"),0);
        BService bs=new BServiceImpl();
        Book book = bs.queryBookById(id);
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice()));
        Map<String,Object> map=new HashMap<>();
        map.put("lastBook",book.getName());
        map.put("allCount",cart.getAllCount());
        req.getSession().setAttribute("lastName",book.getName());
        resp.getWriter().write(new Gson().toJson(map));
    }

}
