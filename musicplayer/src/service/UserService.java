package service;

import dao.UserDao;
import entity.User;

public class UserService {
    public User login(User loginUser) {
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        return user;
    }
    public void register(User newUser) {
        UserDao userDao = new UserDao();
        userDao.register(newUser);
    }
    public String ifExistUser(String username) {
        UserDao userDao = new UserDao();
        String name = userDao.ifExistUser(username);
        return name;
    }
}
