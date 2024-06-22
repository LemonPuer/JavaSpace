package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-19-9:50
 */
public class CustomerDAOimpl extends BaseDAO<Customer> implements customerDAO{
    @Override
    public void insert(Connection conn, Customer cus) {
        String sql="insert into customers(name,email,birth) values(?,?,?)";
        try {
            update(conn,sql,cus.getName(),cus.getEmail(),cus.getBirth());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customers where id = ?";
        try {
            update(conn,sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Connection conn, Customer cust) {
        String sql = "update customers set name = ?,email = ?,birth = ? where id = ?";
        try {
            update(conn, sql,cust.getName(),cust.getEmail(),cust.getBirth(),cust.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Customer> getAll(Connection conn) {
        String sql = "select id,name,email,birth from customers";
        try {
            return select(conn, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Customer> getAll() {
        String sql = "select id,name,email,birth from customers";
        Connection conn = null;
        List<Customer> select =null;
        try {
            conn = getConnection();
            select = select(conn, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return select;
    }
}
