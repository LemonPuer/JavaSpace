package b_1;

import org.junit.Test;

import java.util.Date;

/**
 * @author Lemon
 * @create 2022-09-09-9:52
 */
public class TimeTest {
    @Test
    public void Test(){
        Date date4 = new java.sql.Date(2343243242323L);
        java.sql.Date date5 = (java.sql.Date) date4;

        java.sql.Date date6=new java.sql.Date(2343243242323L);
        System.out.println(date6);
        
    }
}
