package com.demo.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.mybatisplus.mapper.UserMapper;
import com.demo.mybatisplus.pojo.Buser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-12-14-11:49
 */
@SpringBootTest
public class MyTest {
    @Autowired(required = false)
    UserMapper userMapper;

    @Test
    public void test1() {
        List<Buser> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void test2() {
        Buser buser = new Buser(null, "karry", "123456", "john@qq.com");
        int i = userMapper.insert(buser);
        System.out.printf("%d,%s", i, buser);
    }

    @Test
    public void testDeleteById() {
        int result = userMapper.deleteById(1321287682);
        System.out.println("受影响行数：" + result);
    }

    @Test
    public void testUpdateById() {
        //UPDATE buser SET name=?, password=?, email=? WHERE id=?
        Buser buser = new Buser(604000258, "小明", "112233", "xm@qq.com");
        int result = userMapper.updateById(buser);
        System.out.println("受影响行数：" + result);
    }

    @Test
    public void test3() {
        QueryWrapper<Buser> qw = new QueryWrapper<>();
        qw.like("name", "a");
        List<Buser> busers = userMapper.selectList(qw);
        busers.forEach(System.out::println);
    }

    @Test
    public void test4() {
        UpdateWrapper<Buser> uw = new UpdateWrapper<>();
        uw.ne("password", "123456");
        uw.set("password", "123456");
        int update = userMapper.update(null, uw);
        System.out.println(update);
    }

    @Test
    public void test5() {
        Page<Buser> page = new Page<>(1, 3);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
    }

    @Test
    public void test6(){
        Page<Buser> page = new Page<>(1, 3);
        userMapper.myPage(page, "123456");
        page.getRecords().forEach(System.out::println);
    }
}
