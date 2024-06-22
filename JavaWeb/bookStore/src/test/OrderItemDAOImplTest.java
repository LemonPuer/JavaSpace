package test;

import DAO.Order.OrderItem;
import DAO.Order.OrderItemDAO;
import DAO.Order.OrderItemDAOImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Lemon
 * @create 2022-11-01-10:07
 */
public class OrderItemDAOImplTest {
private OrderItemDAO oid=new OrderItemDAOImpl();
    @Test
    public void saveDetails() {
        List<OrderItem> details=new ArrayList<>();
        details.add(new OrderItem(1,"数据结构与算法",1,new BigDecimal(78.5),new BigDecimal(78.5),"1667205635273"));
        details.add(new OrderItem(2,"java 从入门到放弃",1,new BigDecimal(80),new BigDecimal(80),"1667205635273"));
        details.add(new OrderItem(4,"木虚肉盖饭",1,new BigDecimal(16),new BigDecimal(16),"1667205635273"));
        System.out.println(oid.saveDetails(details));
    }

    @Test
    public void selById() {
        System.out.println(oid.selById("1667205635273"));
    }
}