package DAO;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import fruitServlet.AddCus;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Lemon
 * @create 2022-10-17-16:11
 */
public class jtest {
    @Test
    public void test(){
        try {
            Connection conn = AddCus.getConn();
            QueryRunner qr=new QueryRunner();
            String sql="insert into customers(name,email) values('john','john@qq.com')";
            int i = qr.update(conn, sql);
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
