package com.mlxs.web;


import com.mlxs.bean.User;
import com.mlxs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * UserController类描述:
 *
 * @author yangzhenlong
 * @since 2017/5/23
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/403")
    public String to403(){
        return "/err/403";
    }
    @RequestMapping(value = "/404")
    public String to404(){
        return "/err/404";
    }
    @RequestMapping(value = "/500")
    public String to500(){
        return "/err/500";
    }
}
