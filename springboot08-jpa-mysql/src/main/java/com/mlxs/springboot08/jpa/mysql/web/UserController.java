package com.mlxs.springboot08.jpa.mysql.web;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mlxs.springboot08.jpa.mysql.bean.User;
import com.mlxs.springboot08.jpa.mysql.dao.UserDao;
import com.mlxs.springboot08.jpa.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController类描述:
 *
 * @author yangzhenlong
 * @since 2017/4/17
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;
    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/")
    public List<User> index(){
        List<User> all = userDao.findAll();
        return all;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String name, String password){
        User user = userService.login(name, password);
        if(user != null){
            return "登录成功，用户信息：" + user.getUserName();
        }else{
            return "登录失败，用户名或密码不正确";
        }
    }

    @RequestMapping(value = "/findByUserName", method = RequestMethod.GET)
    public String login(String name) throws JsonProcessingException {
        User user = userService.findByUserName(name);
        if(user != null){
            return "用户信息：" + objectMapper.writeValueAsString(user);
        }else{
            return "用户不存在";
        }
    }
}
