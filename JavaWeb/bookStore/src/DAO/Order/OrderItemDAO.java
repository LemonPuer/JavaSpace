package DAO.Order;

import DAO.Cart.Cart;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-31-15:03
 */
public interface OrderItemDAO {
    //保存订单内商品信息
    public int saveDetails(List<OrderItem> details);
    //根据订单号查询商品信息
    public List<OrderItem> selById(String orderId);
}
