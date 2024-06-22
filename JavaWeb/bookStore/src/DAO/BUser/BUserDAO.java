package DAO.BUser;

/**
 * @author Lemon
 * @create 2022-10-22-8:08
 */
public interface BUserDAO {
    //查询用户名是否存在,存在返回ture
    public boolean isExists(String name);
    //查询账号密码是否存在,返回用户信息
    public BUser selectByNAP(String name,String password);
    //保存注册信息
    public int saveBuser(String name,String password,String email);
}
