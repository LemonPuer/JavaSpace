package com.user;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-11-19-13:39
 */
public interface UserMapper {
    //添加固定用户
    int addOne();
    //修改固定用户
    int updateOne();
    //删除固定用户
    int deleteOne();
    //查询固定用户
    User selectOne();
    //查询所有用户
    List<User> selectAll();
    //查询用户数量
    int count();
    //添加用户
    void add(User user);
    //根据id删除用户
    void delete(int id);
    //根据id修改用户
    void update(int id);
    //根据id查询用户
    User select(int id);
}
