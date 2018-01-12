package com.mlxs.springboot.event.web;


import com.mlxs.springboot.event.bean.User;
import com.mlxs.springboot.event.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserRest类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/12
 */
@RestController
public class UserRest {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/all")
    List<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping("/user/register")
    User register(@RequestBody User user){
        return userService.register(user);
    }
}
