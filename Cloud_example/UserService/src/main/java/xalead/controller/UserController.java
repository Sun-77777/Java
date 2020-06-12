package xalead.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xalead.dao.UserDao;
import xalead.entity.User;

import javax.annotation.Resource;
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserDao userDao;
    @RequestMapping("{id}")
    public User findUserById(@PathVariable("id") Integer id){
        return userDao.selectByPrimaryKey(id);
    }
}
