package DAO.Order;

import DAO.BaseDAO;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-31-15:59
 */
public class OrderDAOImpl extends BaseDAO implements OrderDAO{
    @Override
    public int addOrder(Order order) {
        String sql="insert into oder values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getAllPrice(),-1,order.getUserId());
    }

    @Override
    public List<Order> selAll() {
        String sql="select * from oder";
        return selectFOrList(Order.class,sql);
    }

    @Override
    public int change(String orderId,int status) {
        String sql="update oder set status=? where orderId=?";
        return update(sql,status,orderId);
    }

    @Override
    public List<Order> selById(int userId) {
        String sql="select * from oder where userId=?";
        return selectFOrList(Order.class,sql,userId);
    }
}
