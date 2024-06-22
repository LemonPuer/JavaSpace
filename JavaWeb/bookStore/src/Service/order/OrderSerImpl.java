package Service.order;

import DAO.Book.Book;
import DAO.Cart.Cart;
import DAO.Cart.CartItem;
import DAO.Order.*;
import Service.Book.BService;
import Service.Book.BServiceImpl;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Lemon
 * @create 2022-10-31-15:05
 */
public class OrderSerImpl implements OrderService {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private OrderDAO od=new OrderDAOImpl();
    private OrderItemDAO oid=new OrderItemDAOImpl();

    @Override
    public String creatOrder(Cart cart, int userId) {
        Date date=new Date();
        List<OrderItem> details=new ArrayList<>();
        Order order = new Order(userId+""+date.getTime(),sdf.format(date),cart.getAllPrice(),userId);
        //添加订单
        od.addOrder(order);
        Map<Integer, CartItem> items = cart.getItems();
        CartItem ci;
        BService bs=new BServiceImpl();
        //添加商品详情
        for(Map.Entry<Integer,CartItem> e:items.entrySet()){
            ci= e.getValue();
            details.add(new OrderItem(ci.getId(),ci.getName(),ci.getCount(),ci.getPrice(),ci.getXprice(),userId+""+date.getTime()));
            //修改商品的库存和出售数量
            Book book = bs.queryBookById(ci.getId());
            book.setSales(book.getSales()+ci.getCount());
            book.setStock(book.getStock()-ci.getCount());
            bs.updateBook(book);
        }
        oid.saveDetails(details);
        //清空购物车
        cart.clear();
        return userId+""+date.getTime();
    }

    @Override
    public void sentOder(String orderId) {
        od.change(orderId,0);
    }

    @Override
    public List<Order> getAll() {
        return od.selAll();
    }

    @Override
    public List<OrderItem> getDetails(String orderId) {
        return oid.selById(orderId);
    }

    @Override
    public List<Order> userGet(int userId) {
        return od.selById(userId);
    }

    @Override
    public void receiveOder(String orderId) {
        od.change(orderId,1);
    }
}
