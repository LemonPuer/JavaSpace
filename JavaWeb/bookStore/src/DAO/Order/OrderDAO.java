package DAO.Order;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-31-15:03
 */
public interface OrderDAO {
    //生成订单
    public int addOrder(Order order);
    //查询所有订单
    public List<Order> selAll();
    //修改订单状态
    public int change(String orderId,int status);
    //用户ID查询订单
    public List<Order> selById(int userId);
}
