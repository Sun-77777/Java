package model;

import exception.OrderSystemException;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void add() throws OrderSystemException {
        User user = new User();
        user.setName("qqq");
        user.setPassword("qqq");
        user.setIsAdmin(1);
        UserDao userDao = new UserDao();
        userDao.add(user);
    }

    @Test
    public void selectByName() throws OrderSystemException {
        UserDao userDao = new UserDao();
        User user = new User();
        user = userDao.selectByName("111");
        System.out.println(user);
    }

    @Test
    public void selectById() throws OrderSystemException {
        UserDao userDao = new UserDao();
        User user = new User();
        user = userDao.selectById(3);
        System.out.println(user);
    }
}