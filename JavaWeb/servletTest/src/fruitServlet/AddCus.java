package fruitServlet;

import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 可以将数据传输到控制台输出但是不能将数据添加到数据库
 *
 * @author Lemon
 * @create 2022-10-17-15:23
 */
public class AddCus extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String birthString = req.getParameter("birth");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        QueryRunner qr = new QueryRunner();
        Date birth = null;
        Connection conn = null;
        String sql = "insert into customers(name,email,birth) values(?,?,?);";
//      int update = qr.update(conn, sql, name, email, new java.sql.Date(birth.getTime()));
        int update = 0;
        try {
            birth = sdf.parse(birthString);
            System.out.println(name + " " + email + " " + birth);
            conn = getConn();
            update = qr.update(conn, sql, name, email, birthString);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert conn != null;
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (update != 0) {
            System.out.println("添加成功!");
        }
        //req.getRequestDispatcher("selectCus").forward(req,resp);
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
