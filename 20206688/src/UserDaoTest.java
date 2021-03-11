import dao.UserDao;
import entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void login() {
        UserDao userDao = new UserDao();
        User loginUser = new User();
        loginUser.setUsername("111");
        loginUser.setPassword("111");
        userDao.login(loginUser);
    }


    @Test
    public void register() {
        UserDao userDao = new UserDao();
        User newUser = new User();
        newUser.setUsername("222");
        newUser.setPassword("222");
        userDao.register(newUser);
    }


}