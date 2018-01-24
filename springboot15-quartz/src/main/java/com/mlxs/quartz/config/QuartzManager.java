package com.mlxs.quartz.config;


import org.quartz.*;
import org.springframework.stereotype.Component;

/**
 * QuartzManager类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/15
 */
@Component
public class QuartzManager {

    /**
     * JobDetail
     * @param jobName
     * @param jobGroup
     * @param jobClass
     * @return
     */
    public JobDetail createJobDetail(String jobName, String jobGroup, Class<? extends Job> jobClass){
        JobDetail jobDetail = JobBuilder
                .newJob(jobClass)
                .withIdentity(jobName, jobGroup)
                .build();
        return jobDetail;
    }

    public CronTrigger createTrigger(String triggerName, String triggerGroup, String cron){
        CronTrigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity(triggerName, triggerGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        return trigger;
    }

}
