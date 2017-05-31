package com.eureka.rest;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * UserController类描述:
 *
 * @author yangzhenlong
 * @since 2017/4/13
 */
@RestController
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        return "service1 被调用， 请求地址：" + request.getRequestURI();
    }

}
