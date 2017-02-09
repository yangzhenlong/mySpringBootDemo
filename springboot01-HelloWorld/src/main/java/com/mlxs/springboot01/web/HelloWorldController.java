package com.mlxs.springboot01.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldController类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/9
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/index")
    public String index() {
        return "Hello World";
    }
}
