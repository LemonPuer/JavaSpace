package Service.order;

import DAO.Cart.Cart;
import DAO.Order.Order;
import DAO.Order.OrderItem;
import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-31-15:05
 */
public interface OrderService {
    //创建订单
    public String creatOrder(Cart cart,int userId);
    //发货
    public void sentOder(String orderId);
    //查看所有订单
    public List<Order> getAll();
    //查询订单详情
    public List<OrderItem> getDetails(String orderId);
    //用户查看订单
    public List<Order> userGet(int userId);
    //签收
    public void receiveOder(String orderId);
}
