package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Lemon
 * @create 2022-11-19-16:38
 */
public interface UserMapper {
    User checkLoginByParam(@Param("name") String name, @Param("password") String password);

    int insertUser(User user);

    User checkLoginByMap(Map<String, Object> map);

    User checkLogin(String username, String password);

    User select(int id);

    Map<String, Object> userByMap(@Param("id") Integer id);

    List<Map<String,Object>> allByMap();

    @MapKey("id")
    Map<String, Object> allByMapKey();

    List<User> userLike(@Param("name")String name);
}
