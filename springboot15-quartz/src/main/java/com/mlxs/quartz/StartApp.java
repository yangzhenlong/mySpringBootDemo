package com.mlxs.quartz;


import com.mlxs.quartz.config.StartupAllQuartzEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * StartApp类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/14
 */
@SpringBootApplication
public class StartApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StartApp.class, args);
        //启动所有定时任务
        context.publishEvent(new StartupAllQuartzEvent(context));
    }
}
