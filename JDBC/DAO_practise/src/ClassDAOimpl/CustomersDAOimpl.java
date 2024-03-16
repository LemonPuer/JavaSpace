package ClassDAOimpl;

import baseDAO.baseDAO;

import java.sql.Connection;
import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-13-11:21
 */
public class CustomersDAOimpl extends baseDAO<Customers> implements CustomersDAO {
    @Override
    public void insert(Connection conn, Customers cus) {
        String sql="insert into customers(name,email,birth) values(?,?,?)";
        updateData(conn,sql,cus.getName(),cus.getEmail(),cus.getBirth());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customers where id = ?";
        updateData(conn,sql,id);
    }

    @Override
    public void update(Connection conn, Customers cust) {
        String sql = "update customers set name = ?,email = ?,birth = ? where id = ?";
        updateData(conn, sql,cust.getName(),cust.getEmail(),cust.getBirth(),cust.getId());
    }

    @Override
    public Customers getCustomerById(int id) {
        String sql = "select id,name,email,birth from customers where id = ?";
        return selectTable(sql, id);
    }

    @Override
    public List<Customers> getAll(Connection conn) {
        String sql = "select id,name,email,birth from customers";
        return selectTables(conn, sql);
    }
}
