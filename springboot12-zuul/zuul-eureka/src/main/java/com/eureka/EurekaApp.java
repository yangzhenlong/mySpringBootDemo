package com.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * MainApp类描述: 服务注册中心
 *
 * @author yangzhenlong
 * @since 2017/3/16
 */
@EnableEurekaServer//注解启动一个服务注册中心
@SpringBootApplication
public class EurekaApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApp.class, args);
    }
}
