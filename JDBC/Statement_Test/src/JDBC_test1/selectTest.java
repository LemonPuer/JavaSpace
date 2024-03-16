package JDBC_test1;

import org.junit.Test;

import java.sql.*;
import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-11-14:06
 */
public class selectTest {
    @Test
    public void test() throws SQLException {
        Connection conn=JDBCUtils.getConnection();
        String sql="select id,name,email,birth from customers where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,8);
        //执行，获得结果集
        ResultSet rs = ps.executeQuery();
        //将结果集存到一个实例对象中
        if(rs.next()){
            int id=rs.getInt(1);
            String name=rs.getString(2);
            Date birth=rs.getDate(4);
            String email=rs.getString(3);
            System.out.println(new Customers(id, name, email, birth));
        }
        JDBCUtils.closeAll(conn,ps,rs);
    }
    @Test
    public void test1(){
        String sql="select id,name,email,birth from customers where id=?";
        Customers customers = JDBCUtils.selectCus(sql, "8");
        System.out.println(customers);
    }
    @Test
public void test2() throws SQLException {
    Connection conn = JDBCUtils.getConnection();
    String sql="select order_id,order_name,order_date from `order` where order_id=?;";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setObject(1,1);
    ResultSet rs = ps.executeQuery();
    if(rs.next()){
        int orderId=rs.getInt(1);
        String orderName=rs.getString(2);
        Date orderDate=rs.getDate(3);
        System.out.println(new Order(orderId, orderName, orderDate));
    }
    JDBCUtils.closeAll(conn,ps,rs);
}
    @Test
    public void test3(){
        String sql="select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id=?;";
        Order order = JDBCUtils.selectOrder(sql, 1);
        System.out.println(order);
    }
    @Test
    public void test4(){
        String sql="select id,email,name,birth from customers where id<?;";
        List list = JDBCUtils.selectTable(Customers.class, sql,12);
        list.forEach(System.out::println);
        String sql1="select order_id orderId,order_name orderName,order_date orderDate from `order`;";
        list=JDBCUtils.selectTable(Order.class,sql1);
        list.forEach(System.out::println);
    }
}
