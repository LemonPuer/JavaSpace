package com.user;

import com.util.MapperUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.List;


/**
 * @author Lemon
 * @create 2022-11-19-14:11
 */
public class UserMapperTest {
    @Test
    public void addOneTest() throws IOException {
        InputStream rsa = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder ssgb = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = ssgb.build(rsa);
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.addOne());
        rsa.close();
    }
    @Test
    public void updateOne() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = factoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.updateOne());
        is.close();
    }
    @Test
    public void deleteOne() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = factoryBuilder.build(is);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.deleteOne());
        is.close();
    }
    @Test
    public void selectOne(){
        UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
        System.out.println(mapper.selectOne());
    }
    @Test
    public void selectAll(){
        UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
        mapper.selectAll().forEach(user -> System.out.println(user));
    }
    @Test
    public void count(){
        UserMapper mapper = MapperUtil.getMapper(UserMapper.class);
        System.out.println(mapper.count());
    }
}
