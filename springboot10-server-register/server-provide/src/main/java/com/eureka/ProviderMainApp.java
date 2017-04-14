package com.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * MainApp类描述: 服务提供
 *
 * @author yangzhenlong
 * @since 2017/3/16
 */
@EnableDiscoveryClient//激活Eureka中的DiscoveryClient实现
@SpringBootApplication
public class ProviderMainApp {

    public static void main(String[] args) {
        SpringApplication.run(ProviderMainApp.class, args);
    }
}
