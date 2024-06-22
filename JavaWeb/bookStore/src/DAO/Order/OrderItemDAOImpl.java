package DAO.Order;

import DAO.BaseDAO;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.List;

/**
 *id INT PRIMARY KEY AUTO_INCREMENT,
 * `name` VARCHAR(10),
 * `count` INT,
 * price DECIMAL(8,2),
 * xPrice DECIMAL(8,2),
 * orderId VARCHAR(50),
 *  @author Lemon
 * @create 2022-11-01-9:38
 */
public class OrderItemDAOImpl extends BaseDAO implements OrderItemDAO {
    @Override
    public int saveDetails(List<OrderItem> details) {
        String sql="insert into orderitem values(?,?,?,?,?,?)";
        int update=0;
        for (OrderItem o:details){
            update += update(sql, 0, o.getName(), o.getCount(), o.getPrice(), o.getxPrice(), o.getOrderId());
        }
        return update;
    }

    @Override
    public List<OrderItem> selById(String orderId) {
        String sql="select * from orderitem where orderId=?";
        return selectFOrList(OrderItem.class,sql, orderId);
    }
}
