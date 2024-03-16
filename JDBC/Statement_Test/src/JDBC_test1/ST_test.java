package JDBC_test1;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Lemon
 * @create 2022-10-10-22:35
 */
public class ST_test {
    @Test
    public void test() throws Exception {
        //1.读取配置文件的四个信息
        InputStream is = ClassLoader.getSystemResourceAsStream("JDBC_user.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String url = pros.getProperty("url");
        String password = pros.getProperty("password");
        String driver = pros.getProperty("driver");
        //2.加载驱动
        Class.forName(driver);
        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
        if (is != null)
            is.close();
        conn.close();
    }

    @Test
    public void test1() throws Exception {
        InputStream is = ClassLoader.getSystemResourceAsStream("JDBC_user.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String url = pros.getProperty("url");
        String password = pros.getProperty("password");
        String driver = pros.getProperty("driver");
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        Scanner scan=new Scanner(System.in);
        String str1=scan.next();
        String str = "delete from user_table where user='"+str1+"';";
        Statement sm = conn.createStatement();
        sm.execute(str);
        sm.close();
        conn.close();
        is.close();
    }

    @Test
    public void test2() throws Exception {
        InputStream is = ClassLoader.getSystemResourceAsStream("JDBC_user.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String url = pros.getProperty("url");
        String password = pros.getProperty("password");
        String driver = pros.getProperty("driver");
        Class.forName(driver);
        Connection conn=DriverManager.getConnection(url, user, password);
        String str="insert into user_table(user,password) values(?,?)";
        PreparedStatement ps=conn.prepareStatement(str);
        ps.setString(1,"哪吒");
        ps.setString(2,"123456");
//        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
//        Date date=sd.parse("1000-01-01");
//        ps.setDate(3, new java.sql.Date(date.getTime()));
        ps.execute();
        ps.close();
        conn.close();
        is.close();
    }
    @Test
    public void test3(){
        String sql="update user_table set user=? where user=?;";
        JDBCUtils.updateData(sql,"AA","ff");
    }
}
