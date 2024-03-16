package JDBC_test1;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Lemon
 * @create 2022-10-11-10:52
 */
public class JDBCUtils {
    public static Connection getConnection() {
        Connection conn = null;
        InputStream is = null;
        Properties pros = null;
        try {
            is = ClassLoader.getSystemResourceAsStream("JDBC_user.properties");
            pros = new Properties();
            pros.load(is);
            String user = pros.getProperty("user");
            String url = pros.getProperty("url");
            String password = pros.getProperty("password");
            String driver = pros.getProperty("driver");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void updateData(String sql, Object... args) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeAll(conn, ps);
        }
    }

    public static void closeAll(Connection con, Statement state) {
        try {
            if (con != null)
                con.close();
            if (state != null)
                state.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeAll(Connection con, Statement state, ResultSet rs) {
        try {
            if (con != null)
                con.close();
            if (state != null)
                state.close();
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //针对Customers表的通用查询
    public static Customers selectCus(String sql, String... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //执行，获得结果集
            rs = ps.executeQuery();
            //获得结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //列的个数
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                Customers cus = new Customers();
                for (int i = 0; i < columnCount; i++) {
                    //获取每个列的列值：结果集
                    Object value = rs.getObject(i + 1);
                    //获取每个列的列名：结果集的元数据
                    String columnName = rsmd.getColumnName(i + 1);
                    //通过反射修改属性
                    Field field = Customers.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(cus, value);
                }
                return cus;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeAll(conn, ps, rs);
        }
        return null;
    }

    //针对order表的通用查询
    public static Order selectOrder(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            if (rs.next()) {
                Order order = new Order();
                for (int i = 0; i < columnCount; i++) {
                    Object value = rs.getObject(i + 1);
                    //注意：getColumnLabel是获取列的别名，推荐使用
                    String columnlabel = md.getColumnLabel(i + 1);
                    Field field = Order.class.getDeclaredField(columnlabel);
                    field.setAccessible(true);
                    field.set(order, value);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeAll(conn, ps, rs);
        }
        return null;
    }

    public static <T> List selectTable(Class<T> clazz, String sql, Object... args) {
        List<T> list = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            list = new ArrayList<>();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //获取数据
                    Object value = rs.getObject(i + 1);
                    //获取列名
                    String columnLabel = md.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, value);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, ps, rs);
        }
        return null;
    }
}
