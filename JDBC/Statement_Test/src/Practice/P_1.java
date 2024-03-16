package Practice;

import JDBC_test1.JDBCUtils;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Lemon
 * @create 2022-10-11-20:37
 */
public class P_1 {
    @Test
    public void test() throws Exception {
        InputStream is = ClassLoader.getSystemResourceAsStream("JDBC_user.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String url = pros.getProperty("url");
        String password = pros.getProperty("password");
        String driver = pros.getProperty("driver");
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "update customers set name=?,email=?,birth=? where id=4;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, "刘德华");
        ps.setObject(2, "LDH@126.com");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sf.parse("1990-12-12");
        ps.setObject(3, new java.sql.Date(date.getTime()));
        ps.execute();
    }

    @Test
    public void test1() {
        Connection conn = JDBCUtils.getConnection();
        Scanner scan = new Scanner(System.in);
        String sql = "insert into examstudent(Type,IDCard,ExamCard,StudentName,Location,Grade) values(?,?,?,?,?,?);";
        System.out.println("Type:");
        int type = scan.nextInt();
        System.out.println("IDCard:");
        String idCard = scan.next();
        System.out.println("ExamCard:");
        String examCard = scan.next();
        System.out.println("StudentName:");
        String name = scan.next();
        System.out.println("Location:");
        String location = scan.next();
        System.out.println("Grade:");
        String grade = scan.next();
        //6,"454525695263214584","200523164754006","王五","广州",75
        int i = updateData(sql, type, idCard, examCard, name, location, grade);
        if(i>0){
            System.out.println("信息录入成功!");
        }
    }

    public static int updateData(String sql, Object... args) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps=null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeAll(conn, ps);
        }
        return 0;
    }
}
