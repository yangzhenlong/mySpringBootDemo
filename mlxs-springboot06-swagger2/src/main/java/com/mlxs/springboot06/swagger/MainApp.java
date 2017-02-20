package com.mlxs.springboot06.swagger;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * MainApp类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/20
 */
@SpringBootApplication
@EnableSwagger2 //启动swagger注解 启动服务，浏览器输入"http://服务名:8080/swagger-ui.html"
@ComponentScan(basePackages = {"com.mlxs.springboot06.swagger"})
public class MainApp {
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
}
