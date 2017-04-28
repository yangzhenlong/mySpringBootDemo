package com.eureka.feign;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ProviderFeignClient接口描述:
 *
 * @author yangzhenlong
 * @since 2017/4/14
 */
@FeignClient("provider")//注册中心注册的服务名称，也就是serviceId
public interface ProviderFeignClient {

    @RequestMapping("/add/{name}")
    String add(@RequestParam(value = "name") String name);

    @RequestMapping("/getAll")
    String getAll();
}
