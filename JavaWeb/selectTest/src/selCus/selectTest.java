package selCus;

import DAO.Customer;
import DAO.CustomerDAOimpl;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-19-10:59
 */
public class selectTest {
    @Test
    public void test(){
        CustomerDAOimpl cdi=new CustomerDAOimpl();
        List<Customer> list = cdi.getAll();
        for (Customer c:list) {
            System.out.println(c);
        }
    }
    @Test
    public void test2(){
        int[] a=new int[]{1,23,45,6,5,7,8,9};
        System.out.println(Arrays.toString(a));
    }
}
