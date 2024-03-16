package com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Lemon
 * @create 2022-11-19-15:24
 */
public class MapperUtil {
    public static <T> T getMapper(Class<T> clazz){
        T mapper=null;
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            SqlSession sqlSession = factory.openSession(true);
            mapper = sqlSession.getMapper(clazz);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapper;
    }
}
