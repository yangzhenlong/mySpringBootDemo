package com.mlxs.springboot05.redis.use02;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestMethod类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/16
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @RequestMapping("/str")
    @Cacheable(value = "redisTest")
    public String queryStr(String str){
        System.out.println("---请求参数---" + str);

        return "queryStr return: " + str;
    }
}
