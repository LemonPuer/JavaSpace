package d_exer2;

import org.junit.Test;

/**
 * @author Lemon
 * @create 2022-09-21-11:13
 */
public class DAOTest {
    @Test
    public void Test(){
        DAO<User> u = new DAO<User>();
        u.save("1",new User(1,23,"liming"));
        u.save("2",new User(1,23,"liming"));
        System.out.println(u.get("1"));
        u.update("1",new User(2,32,"wangwu"));
        System.out.println(u.get("1"));
        System.out.println(u.list());
        u.delete("2");
        System.out.println(u.list());
    }
}
