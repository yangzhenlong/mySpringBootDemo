package com.mlxs.springboot01.web;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * MyApplicationRunner类描述:
 *
 * @author yangzhenlong
 * @since 2018/2/8
 */
@Component
@Order(1)
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("-------------->" + "项目启动，now=" + new Date());
        myTimer();
    }

    public static void myTimer(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("------定时任务--------");
            }
        }, 0, 1000);
    }
}
