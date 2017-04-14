package com.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * MainApp类描述: 服务提供
 *
 * @author yangzhenlong
 * @since 2017/3/16
 */
@EnableDiscoveryClient//发现服务
@SpringBootApplication
public class ClientRibbonMainApp {

    @Bean
    @LoadBalanced//开启均衡负载能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientRibbonMainApp.class, args);
    }
}
