import com.mapper.UserMapper;
import com.pojo.User;
import com.util.MapperUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lemon
 * @create 2022-11-19-16:52
 */
public class userTest {
    @Test
    public void checkLogin() {
        UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
        System.out.println(mapper.checkLogin("ladygaga", "123456"));
    }

    @Test
    public void insertUser() {
        UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
        User user=new User("john", "123456", "xian", "123456");
        System.out.println(mapper.insertUser(user));
        System.out.println(user.getId());
    }

    @Test
    public void checkLoginByMap() {
        UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name","john");
        map.put("password","123456");
        System.out.println(mapper.checkLoginByMap(map));
    }

    @Test
    public void checkLoginByParam() {
        UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
        System.out.println(mapper.checkLoginByParam("john", "123456"));
    }
    @Test
    public void select() {
        UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
        System.out.println(mapper.select(8));
    }
    @Test
    public void userByMap() {
        UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
        System.out.println(mapper.userByMap(1));
    }
    @Test
    public void allByMap() {
        UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
        System.out.println(mapper.allByMap());
    }
    @Test
    public void allByMapKey() {
        UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
        System.out.println(mapper.allByMapKey());
    }
    @Test
    public void userLike() {
        UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
        System.out.println(mapper.userLike("o"));
    }
}
