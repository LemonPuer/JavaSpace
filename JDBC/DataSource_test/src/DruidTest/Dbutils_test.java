package DruidTest;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Lemon
 * @create 2022-10-13-16:30
 */
public class Dbutils_test {
    @Test
    public void test() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        QueryRunner qr = new QueryRunner();
        String sql="update user_table set password=123456 where user=?";
        qr.update(conn,sql,"aa");
        JDBCUtils.closeAll(conn,null);
    }
    @Test
    public void test1() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        QueryRunner qr = new QueryRunner();
        String sql="select id,name,email,birth from customers where id=?";
        BeanHandler<Customers> hander=new BeanHandler<>(Customers.class);
        Customers cus = qr.query(conn, sql, hander, 20);
        System.out.println(cus);
    }
}
