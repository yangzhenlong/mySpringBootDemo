package com.mlxs.springboot04.mongodb.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * MainApp类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/13
 */
@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.mlxs.springboot04.mongodb.dao"})
public class MainApp {

    public static void main(String[] args) {

        SpringApplication.run(MainApp.class, args);
    }
}
