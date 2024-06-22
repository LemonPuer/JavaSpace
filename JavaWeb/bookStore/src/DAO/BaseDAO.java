package DAO;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-21-21:40
 */
public abstract class BaseDAO {
    //对于数据库修改操作，返回修改的数据条数
    public int update(String sql,Object...orgs){
        Connection conn = JDBCUtils.getConn();
        QueryRunner qr=new QueryRunner();
        try {
            return qr.update(conn,sql,orgs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public <T>T selectByOne(Class<T> clazz,String sql,Object...args){
        Connection conn = JDBCUtils.getConn();
        QueryRunner qr=new QueryRunner();
        BeanHandler<T> handler=new BeanHandler<>(clazz);
        try {
            return qr.query(conn,sql,handler,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public <T> List<T> selectFOrList(Class<T> clazz,String sql,Object...args){
        Connection conn=JDBCUtils.getConn();
        QueryRunner qr=new QueryRunner();
        BeanListHandler<T> handler=new BeanListHandler<>(clazz);
        try {
            return qr.query(conn,sql,handler,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public Object singleRes(String sql,Object...args){
        Connection conn=JDBCUtils.getConn();
        QueryRunner qr=new QueryRunner();
        ScalarHandler handler=new ScalarHandler();
        try {
            return qr.query(conn,sql, handler,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
