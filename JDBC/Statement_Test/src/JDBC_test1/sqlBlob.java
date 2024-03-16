package JDBC_test1;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author Lemon
 * @create 2022-10-12-14:21
 */
public class sqlBlob {
    @Test
    public void test() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select name,photo from customers where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, 16);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Customers cus = new Customers();
            String value = rs.getString("name");
            Field name = Customers.class.getDeclaredField("name");
            name.setAccessible(true);
            name.set(cus, value);
            System.out.println(cus);

            Blob photo = rs.getBlob("photo");
            InputStream is = photo.getBinaryStream();
            byte[] arr = new byte[1024];
            int len = 0;
            OutputStream os = new BufferedOutputStream(new FileOutputStream("JDBC_test1.jpg"));
            while ((len = is.read(arr)) != -1) {
                os.write(arr, 0, len);
            }
        }
        JDBCUtils.closeAll(conn, ps, rs);
    }

    @Test
    public void test1() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql = "update customers set photo=? where id=12";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setBlob(1, new FileInputStream("JDBC_test1.jpg"));
        ps.execute();
        JDBCUtils.closeAll(conn, ps);
    }

    @Test
    public void test2() throws Exception {
        long start = System.currentTimeMillis();
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into test6(name) values(?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        //设置不允许自动提交数据
        conn.setAutoCommit(false);
        for (int i = 1; i <= 1000000; i++) {
            ps.setObject(1, "name_" + i);
            //1."攒"sql
            ps.addBatch();
            if (i % 500 == 0) {
                //2.执行batch
                ps.executeBatch();
                //3.清空batch
                ps.clearBatch();
            }
        }
        //提交数据
        conn.commit();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        JDBCUtils.closeAll(conn, ps);
    }
}
