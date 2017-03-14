package com.mlxs.springboot08.jpa.mysql.service;


import com.mlxs.springboot08.jpa.mysql.bean.User;
import com.mlxs.springboot08.jpa.mysql.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/21
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findById(Long id){
        return userDao.findOne(id);
    }

    public User findByUserName(String userName){
        return userDao.findByUserName(userName);
    }

    public User login(String userName, String password){
        return userDao.findByUserNameAndPassword(userName, password);
    }

    public List<User> userList(){
        return userDao.findAll();
    }
}
