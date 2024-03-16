package ClassDAOimpl;

import java.sql.Connection;
import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-13-11:21
 */
public interface CustomersDAO  {
    //将cust对象添加到数据库中
    void insert(Connection conn, Customers cus);
    //针对指定的id，删除表中的一条记录
    void deleteById(Connection conn,int id);
    //针对内存中的cust对象，去修改数据表中指定的记录
    void update(Connection conn,Customers cust);
    //针对指定的id查询得到对应的Customer对象
    Customers getCustomerById(int id);
    //查询表中的所有记录构成的集合
    List<Customers> getAll(Connection conn);
}
