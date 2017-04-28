package com.eureka.rest;


import com.eureka.feign.ProviderFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * UserController类描述:
 *
 * @author yangzhenlong
 * @since 2017/4/13
 */
@RestController
public class FeignController {

    private final static Logger LOGGER = LoggerFactory.getLogger(FeignController.class);
    @Autowired
    private ProviderFeignClient providerFeignClient;
    @RequestMapping("/feign")
    public String index(){
        String all = providerFeignClient.getAll();
        return "------" + all;
    }

}
