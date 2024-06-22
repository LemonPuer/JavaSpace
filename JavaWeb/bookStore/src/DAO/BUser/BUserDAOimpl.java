package DAO.BUser;

import DAO.BaseDAO;

/**
 * @author Lemon
 * @create 2022-10-22-8:15
 */
public class BUserDAOimpl extends BaseDAO implements BUserDAO{
    private Class<BUser> clazz=BUser.class;
    @Override
    public boolean isExists(String name) {
        String sql="select * from buser where name=?";
        BUser bUser = selectByOne(clazz, sql, name);
        if(bUser==null)
            return false;
        return true;
    }

    @Override
    public BUser selectByNAP(String name,String password) {
        String sql="select * from buser where name=? and password=?";
        BUser bUser = selectByOne(clazz, sql, name, password);
        return bUser;
    }

    @Override
    public int saveBuser(String name,String password,String email) {
        String sql="insert into buser(name,password,email) values(?,?,?)";
        return update(sql, name, password, email);
    }
}
