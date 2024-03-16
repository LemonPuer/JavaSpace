package JDBC_test2;

import JDBC_test1.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Lemon
 * @create 2022-10-12-21:23
 */
public class commitTest {
@Test
public void test() {
    Connection conn = null;
    try {
        conn = JDBCUtils.getConnection();
        //1.取消数据的自动提交
        conn.setAutoCommit(false);
        String sql = "update user_table set balance=balance-100 where user=?";
        updateData(conn, sql, "aa");
        //模拟网络传输异常
        System.out.println(10 / 0);
        sql = "update user_table set balance=balance+100 where user=?";
        updateData(conn,sql, "bb");
        System.out.println("转账成功");
        //2.提交数据
        conn.commit();
    } catch (SQLException e) {
        e.printStackTrace();
        try {
            //3.出现异常回滚数据
            conn.rollback();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    } finally {
        JDBCUtils.closeAll(conn, null);
    }
}

    //通用的增删改操作---version 2.0 （考虑上事务）
    public int updateData(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeAll(null, ps);
        }
        return 0;
    }
}
