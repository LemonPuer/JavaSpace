package bookStoreServlet;

import DAO.Cart.Cart;
import DAO.Order.Order;
import DAO.Order.OrderItem;
import DAO.Tool;
import Service.order.OrderSerImpl;
import Service.order.OrderService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Lemon
 * @create 2022-11-01-11:20
 */
public class OrderServlet extends baseServlet {
    private OrderService os = new OrderSerImpl();

    protected void addO(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        int userId = (Integer) session.getAttribute("userId");
        String s = os.creatOrder(cart, userId);
        session.setAttribute("orderId", s);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    protected void sent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        os.sentOder(orderId);
        resp.sendRedirect(req.getContextPath() + "/orderServlet?action=getAll");
    }

    protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> all = os.getAll();
        req.setAttribute("all", all);
        req.getSession().setAttribute("all", all);
        req.getRequestDispatcher("/pages/manager/order.jsp").forward(req, resp);
    }

    protected void getDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        int a = Tool.parseInt(req.getParameter("a"), 1);
        List<OrderItem> details = os.getDetails(orderId);
        req.setAttribute("details", details);
        if (a == 0)
            req.getRequestDispatcher("/pages/manager/details.jsp").forward(req, resp);
        req.getRequestDispatcher("/pages/order/details.jsp").forward(req, resp);

    }

    protected void getMine(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (Integer) req.getSession().getAttribute("userId");
        List<Order> orders = os.userGet(userId);
        req.getSession().setAttribute("orders", orders);
        resp.sendRedirect(req.getContextPath() + "/pages/order/order.jsp");
    }

    protected void receive(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        os.receiveOder(orderId);
        resp.sendRedirect(req.getContextPath() + "/orderServlet?action=getMine");
    }
}
