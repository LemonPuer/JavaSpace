package DAO;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Lemon
 * @create 2022-10-21-21:40
 */
public class JDBCUtils {
    private static DataSource dataSource;
    private static final ThreadLocal<Connection> cons = new ThreadLocal<>();

    static {
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("JDBC_user.properties");
        Properties ps = new Properties();
        try {
            ps.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(ps);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert is != null;
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConn() {
        Connection conn = cons.get();
        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                cons.set(conn);
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return conn;
    }

    public static void commit() {
        Connection conn = cons.get();
        if (conn != null) {
            try {
                conn.commit();
                conn.setAutoCommit(true);
                conn.close();
                cons.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void rollback() {
        Connection conn = cons.get();
        if (conn != null) {
            try {
                conn.rollback();
                conn.setAutoCommit(true);
                conn.close();
                cons.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
