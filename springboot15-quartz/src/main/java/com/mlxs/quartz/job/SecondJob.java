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
public class SecondJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("》》》》》》》》》》2222222222222 excute-----" + new Date());
    }
}
