package fruitServlet;

import DAO.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-18-19:21
 */
public class selectCus extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Connection conn =null;
        String sql="select id,name,email,birth from customers;";
        List<Customer> list =null;
        try {
            conn = getConn();
            QueryRunner qr=new QueryRunner();
            BeanListHandler<Customer> handler=new BeanListHandler<>(Customer.class);
            list = qr.query(conn, sql, handler);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                assert conn != null;
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        session.setAttribute("List",list);
        super.processTemplate("selectCus",req,resp);
    }
    public static Connection getConn() throws IOException, ClassNotFoundException, SQLException {
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true&useServerPrepStmts=false";
        String USER = "root";
        String PWD = "123456";
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PWD);
        return conn;
    }
}
