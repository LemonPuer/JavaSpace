package Service.BUser;

import DAO.BUser.BUser;

/**
 * @author Lemon
 * @create 2022-10-26-11:47
 */
public interface UService {
    //查询用户名是否存在,存在返回false
    public boolean isExists(String name);
    //查询账号密码是否存在,返回用户信息
    public BUser selectByNAP(String name, String password);
    //保存注册信息
    public int saveBuser(String name,String password,String email);
}
