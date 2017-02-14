package com.mlxs.springboot.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * MainApp类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/13
 */
@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(MainApp.class, args);
        /*String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("-------- bean名称打印 --------");
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }*/
    }
}
