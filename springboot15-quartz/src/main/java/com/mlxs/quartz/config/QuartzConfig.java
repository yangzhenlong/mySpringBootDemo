package com.mlxs.quartz.config;


import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * QuartzConfig类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/14
 */
@Configuration
public class QuartzConfig {

    /**
     * 配置定时任务 调度器
     * @return
     */
    @Bean(name = "scheduler")
    public Scheduler scheduler() throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();
        scheduler.start();
        return scheduler;
    }
}
