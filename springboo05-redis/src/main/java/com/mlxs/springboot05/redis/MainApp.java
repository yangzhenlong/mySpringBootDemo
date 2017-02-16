package com.mlxs.springboot05.redis;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * MainApp类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/16
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.mlxs.springboot05.redis"})
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
}
