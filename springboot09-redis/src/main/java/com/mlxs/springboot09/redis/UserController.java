package com.mlxs.springboot09.redis;


import com.mlxs.springboot09.redis.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController类描述:
 *
 * @author yangzhenlong
 * @since 2017/3/16
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> list(){
        return userService.users();
    }
}
