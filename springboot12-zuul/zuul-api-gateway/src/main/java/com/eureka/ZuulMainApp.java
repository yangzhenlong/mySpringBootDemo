package com.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * MainApp类描述: 服务注册中心
 *
 * @author yangzhenlong
 * @since 2017/3/16
 */
@EnableZuulProxy//声明zuul代理
@SpringBootApplication
public class ZuulMainApp {

    public static void main(String[] args) {
        SpringApplication.run(ZuulMainApp.class, args);
    }
}
