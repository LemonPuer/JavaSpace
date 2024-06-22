package test;

import DAO.Book.Book;
import DAO.Cart.Cart;
import DAO.Cart.CartItem;
import Service.order.OrderSerImpl;
import Service.order.OrderService;
import com.google.gson.Gson;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Lemon
 * @create 2022-11-01-10:48
 */
public class OrderSerImplTest {
    private OrderService os = new OrderSerImpl();

    @Test
    public void creatOrder() {
        Cart cart = new Cart();
        Book book = new Book(1, "数据结构与算法", new BigDecimal(78.5), "严敏君", 6, 13, null);
        cart.addItem(new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice()));
        System.out.println(os.creatOrder(cart, 1));
    }

    @Test
    public void sentOder() {
        os.sentOder("11667272476494");
    }

    @Test
    public void getAll() {
        System.out.println(os.getAll());
    }

    @Test
    public void getDetails() {
        System.out.println(os.getDetails("11667272476494"));
    }

    @Test
    public void userGet() {
        os.userGet(1);
    }

    @Test
    public void receiveOder() {
        os.receiveOder("11667272476494");
    }

}
