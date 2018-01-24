package com.mlxs.quartz.job;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * MyJob3类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/15
 */
public class MyJob3 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("job 3 execute... ... ...");
    }
}
