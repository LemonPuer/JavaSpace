package ClassDAOimpl;

import JDBCUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;

import static org.junit.Assert.*;

/**
 * @author Lemon
 * @create 2022-10-13-15:06
 */
public class CustomersDAOimplTest {

    @org.junit.Test
    public void insert() {
        Connection conn = JDBCUtils.getConnection();
        CustomersDAOimpl cdi = new CustomersDAOimpl();
        Customers cus = new Customers(5, "张三", "zhangsan@qq.com", new Date(165789465l));
        cdi.insert(conn,cus);
    }

    @org.junit.Test
    public void deleteById() {
    }

    @org.junit.Test
    public void update() {
    }

    @org.junit.Test
    public void getCustomerById() {
    }

    @org.junit.Test
    public void getAll() {
    }
}