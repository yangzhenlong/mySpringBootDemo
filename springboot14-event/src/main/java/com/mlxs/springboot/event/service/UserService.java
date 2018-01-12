package com.mlxs.springboot.event.service;


import com.mlxs.springboot.event.bean.User;
import com.mlxs.springboot.event.event.UserRegisterEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * UserService类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/12
 */
@Service
public class UserService {
    @Autowired
    private ApplicationContext applicationContext;

    private List<User> userList = new ArrayList<>();

    public User register(User user) {
        userList.add(user);
        //发布事件
        applicationContext.publishEvent(new UserRegisterEvent(this, user));
        return user;
    }

    public List<User> getAll(){
        return userList;
    }
}
