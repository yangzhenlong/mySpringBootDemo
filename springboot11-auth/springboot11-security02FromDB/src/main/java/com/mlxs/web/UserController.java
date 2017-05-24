package com.mlxs.web;


import com.mlxs.bean.User;
import com.mlxs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * UserController类描述:
 *
 * @author yangzhenlong
 * @since 2017/5/23
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String index(){
        return "/index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "/login";
    }

    @RequestMapping(value = "/home")
    @PreAuthorize("hasAnyAuthority('ADMIN')")//需要admin权限，该注解必须在websecurity配置类中添加@EnableGlobalMethodSecurity(prePostEnabled = true)
    public String home(){
        return "/home";
    }

    @RequestMapping(value = "/test500")
    public String test500(){
        User u = null;
        String role = u.getRole();
        return "/home";
    }

    @RequestMapping(value = "/userList")
    @PreAuthorize("hasAnyAuthority('USER')")
    public String userList(ModelMap modelMap){
        List<User> users = userService.userList();
        modelMap.addAttribute("userList", users);
        return "/userList";
    }
}
