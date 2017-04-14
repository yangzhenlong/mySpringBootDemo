package com.eureka.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * UserController类描述:
 *
 * @author yangzhenlong
 * @since 2017/4/13
 */
@RestController()
public class RibbonController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RibbonController.class);
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/add/{name}")
    public String add(@PathVariable String name){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://PROVIDER/add/" + name, String.class);
        return forEntity.getBody();
    }
}
