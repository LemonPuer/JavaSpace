package DruidTest;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Lemon
 * @create 2022-10-13-14:58
 */
public class Druid_test {
    @Test
    public void test() throws Exception {
        InputStream is = ClassLoader.getSystemResourceAsStream("druid.properties");
        Properties pros=new Properties();
        pros.load(is);
        DataSource druid = DruidDataSourceFactory.createDataSource(pros);
        Connection conn = druid.getConnection();

        System.out.println(conn);
    }
}
