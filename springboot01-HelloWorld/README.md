# mySpringBootDemo
# springboot demo
# 第一个springboot程序

 

# 新建maven项目，添加如下依赖：

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <!--项目信息-->
    <groupId>com.mlxs.springboot.helloworld</groupId>
    <artifactId>mlxs-springboot-helloworld</artifactId>
    <version>1.0-SNAPSHOT</version>

    <!--父依赖包-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.3.2.RELEASE</version>
        <relativePath/>
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

    </dependencies>
</project>

# 新建项目启动类：


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MainApp类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/9
 */
@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
}

# 新建restful接口类：

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldController类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/9
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/index")
    public String index() {
        return "Hello World";
    }
}

 

# 然后启动MainApp，浏览器中访问：http://localhost:8080/index，得到响应：

Hello World
