package test;

import DAO.Order.Order;
import DAO.Order.OrderDAO;
import DAO.Order.OrderDAOImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lemon
 * @create 2022-10-31-16:26
 */
public class OrderDAOImplTest {
    public OrderDAO od = new OrderDAOImpl();

    @Test
    public void addOrder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Order order = new Order( 1+""+new Date().getTime(),sdf.format(new Date()), new BigDecimal(174.5), 1);
        System.out.println(od.addOrder(order));
    }

    @Test
    public void selAll() {
        System.out.println(od.selAll());
    }

    @Test
    public void change() {
        System.out.println(od.change("1667205635273", 0));
    }

    @Test
    public void selById() {
        System.out.println(od.selById(1));
    }

    @Test
    public void test() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = sdf.format(new Date());
        System.out.println(format);
    }
}