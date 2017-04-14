package com.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * MainApp类描述: 服务提供
 *
 * @author yangzhenlong
 * @since 2017/3/16
 */
@EnableDiscoveryClient//发现服务
@EnableFeignClients//开启Feign功能
@SpringBootApplication
public class ClientFeignMainApp {

    public static void main(String[] args) {
        SpringApplication.run(ClientFeignMainApp.class, args);
    }
}
