package Service.BUser;

import DAO.BUser.BUser;
import DAO.BUser.BUserDAO;
import DAO.BUser.BUserDAOimpl;

/**
 * @author Lemon
 * @create 2022-10-26-11:47
 */
public class UServiceImpl implements UService {
    private BUserDAO bud=new BUserDAOimpl();
    @Override
    public boolean isExists(String name) {
        return bud.isExists(name);
    }

    @Override
    public BUser selectByNAP(String name, String password) {
        return bud.selectByNAP(name,password);
    }

    @Override
    public int saveBuser(String name, String password, String email) {
        return bud.saveBuser(name, password, email);
    }

}
