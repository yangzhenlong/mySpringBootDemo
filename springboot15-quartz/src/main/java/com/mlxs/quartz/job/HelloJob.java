package com.mlxs.quartz.job;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * HelloJob类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/15
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String params = jobExecutionContext.getMergedJobDataMap().getString("params");
        System.out.println("------ HelloJob excute， params= "+ params +" -----" + new Date());
    }
}
