package DAO;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * @author Lemon
 * @create 2022-10-19-9:30
 */
public abstract class BaseDAO<T> {
    private Class<T> clazz=null;
    {
        //获取当前BaseDAO的子类继承的父类中的泛型
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;

        Type[] typeArguments = paramType.getActualTypeArguments();//获取了父类的泛型参数
        clazz = (Class<T>) typeArguments[0];//泛型的第一个参数

    }
    public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true&useServerPrepStmts=false";
        String USER = "root";
        String PWD = "123456";
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PWD);
        return conn;
    }
    public void update(Connection conn,String sql,Object...args) throws SQLException {
        QueryRunner qr=new QueryRunner();
            qr.update(conn,sql,args);
    }
    public List<T> select(Connection conn,String sql,Object...args) throws SQLException {
        QueryRunner qr=new QueryRunner();
        BeanListHandler<T> handler=new BeanListHandler<>(clazz);
        List<T> list = qr.query(conn, sql, handler, args);
        return list;
    }
}
