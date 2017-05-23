package com.mlxs.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserController类描述:
 *
 * @author yangzhenlong
 * @since 2017/5/23
 */
@Controller
public class UserController {

    @RequestMapping(value = "/")
    public String index(){
        return "/index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "/login";
    }

    @RequestMapping(value = "/home")
    public String home(){
        return "/home";
    }
}
