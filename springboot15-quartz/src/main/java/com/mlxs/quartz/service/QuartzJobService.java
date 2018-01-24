package com.mlxs.quartz.service;


import com.mlxs.quartz.Constants;
import com.mlxs.quartz.bean.JobClass;
import com.mlxs.quartz.bean.QuartzJob;
import com.mlxs.quartz.config.QuartzManager;
import com.mlxs.quartz.dao.JobClassRepository;
import com.mlxs.quartz.dao.QuartzJobRepository;
import com.mlxs.quartz.web.Result;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * QuartzJobService类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/22
 */
@Service
public class QuartzJobService {

    @Resource(name = "scheduler")
    private Scheduler scheduler;
    @Autowired
    private QuartzManager quartzManager;
    @Autowired
    private QuartzJobRepository quartzJobRepository;
    @Autowired
    private JobClassRepository jobClassRepository;

    public List<QuartzJob> getAllJob(){
        return quartzJobRepository.findAll();
    }

    public List<JobClass> getAllClass(){
        return jobClassRepository.findAll();
    }

    public Result addJobClass(String className){
        JobClass jobClass = jobClassRepository.findOneByFullClass(className);
        if(jobClass != null){
            return Result.error("-1000", "类名已存在");
        }
        jobClass = new JobClass();
        jobClass.setFullClass(className);
        jobClassRepository.save(jobClass);
        return Result.success("");
    }

    public QuartzJob getOneJob(String id){
        return quartzJobRepository.findOne(id);
    }

    public Result addJob(QuartzJob job){
        job.setId((quartzJobRepository.getMaxId() + 1) + "");
        job.setStatus("0");
        job.setJobGroup(Constants.DEFAULT_JOB_GROUP);
        job.setTriggerName("trigger_" + job.getJobName());
        job.setTriggerGroup(Constants.DEFAULT_TRIGGER_GROUP);
        job.setCreateTime(new Date());
        QuartzJob save = quartzJobRepository.save(job);
        return Result.success(save);
    }

    public void startAllJob() throws SchedulerException {
        List<QuartzJob> quartzJobs = quartzJobRepository.findByStatus("1");
        for(QuartzJob job : quartzJobs){
            Class<Job> jobClass = null;
            try {
                jobClass = (Class<Job>)Class.forName(job.getFullClass());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("xxxxxxxxxx  启动任务["+job.getJobName()+"]失败，类名错误，请检查：" + job.getFullClass());
                break;
            }
            JobDetail jobDetail = quartzManager.createJobDetail(job.getJobName(), job.getJobGroup(), jobClass);
            CronTrigger trigger1 = quartzManager.createTrigger(job.getTriggerName(), job.getTriggerGroup(), job.getCronExpression());
            scheduler.scheduleJob(jobDetail, trigger1);
            System.out.println("启动任务["+job.getJobName()+"] 成功");
        }
    }


    public Result startJob(String jobId) throws SchedulerException {
        QuartzJob quartzJob = quartzJobRepository.findOne(jobId);
        if(quartzJob == null){
            return Result.error("-10001", "任务不存在");
        }
        if("1".equals(quartzJob.getStatus())){
            return Result.error("-10001", "任务已经运行");
        }
        Class<Job> jobClass = null;
        try {
            jobClass = (Class<Job>)Class.forName(quartzJob.getFullClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return Result.error("-10001", "类名错误，请检查：" + quartzJob.getFullClass());
        }
        JobDetail jd1 = quartzManager.createJobDetail(quartzJob.getJobName(), quartzJob.getJobGroup(), jobClass);
        //jd1.getJobDataMap().put("params", "this is params");
        CronTrigger trigger1 = quartzManager.createTrigger(quartzJob.getTriggerName(), quartzJob.getTriggerGroup(), quartzJob.getCronExpression());
        scheduler.scheduleJob(jd1, trigger1);
        quartzJob.setStatus("1");
        quartzJob.setCreateTime(new Date());
        quartzJobRepository.save(quartzJob);
        return Result.success("");
    }

    public Result pauseJob(String jobId) throws SchedulerException {
        QuartzJob quartzJob = quartzJobRepository.findOne(jobId);
        if(quartzJob == null){
            return Result.error("-10001", "任务不存在");
        }
        if(!"1".equals(quartzJob.getStatus())){
            return Result.error("-10002", "任务不是运行状态");
        }
        scheduler.pauseJob(JobKey.jobKey(quartzJob.getJobName(), quartzJob.getJobGroup()));
        quartzJob.setStatus("2");
        quartzJob.setUpdateTime(new Date());
        quartzJobRepository.save(quartzJob);
        return Result.success("");
    }
    public Result resumeJob(String jobId) throws SchedulerException {
        QuartzJob quartzJob = quartzJobRepository.findOne(jobId);
        if(quartzJob == null){
            return Result.error("-10001", "任务不存在");
        }
        if(!"2".equals(quartzJob.getStatus())){
            return Result.error("-10002", "任务不是暂停状态");
        }
        scheduler.resumeJob(JobKey.jobKey(quartzJob.getJobName(), quartzJob.getJobGroup()));
        quartzJob.setUpdateTime(new Date());
        quartzJob.setStatus("1");
        quartzJobRepository.save(quartzJob);
        return Result.success("");
    }

    public Result updateJobCron(String jobId, String cronExpression){
        QuartzJob quartzJob = quartzJobRepository.findOne(jobId);
        if(quartzJob == null){
            return Result.error("-10001", "任务不存在");
        }
        if(cronExpression.equals(quartzJob.getCronExpression())){
            return Result.error("-10002", "表达式与原来的相同");
        }
        quartzJob.setCronExpression(cronExpression);
        quartzJobRepository.save(quartzJob);
        if("1".equals(quartzJob.getStatus())) {
            try {
                JobKey jobKey = JobKey.jobKey(quartzJob.getJobName(), quartzJob.getJobGroup());
                scheduler.pauseJob(jobKey);//暂停任务
                scheduler.deleteJob(jobKey);//删除任务
                //重新启动一个任务
                Class<Job> jobClass = null;
                try {
                    jobClass = (Class<Job>)Class.forName(quartzJob.getFullClass());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return Result.error("-10001", "类名错误，请检查：" + quartzJob.getFullClass());
                }
                JobDetail jd1 = quartzManager.createJobDetail(quartzJob.getJobName(), quartzJob.getJobGroup(), jobClass);
                //jd1.getJobDataMap().put("params", "this is params");
                CronTrigger trigger1 = quartzManager.createTrigger(quartzJob.getTriggerName(), quartzJob.getTriggerGroup(), quartzJob.getCronExpression());
                scheduler.scheduleJob(jd1, trigger1);
            } catch (SchedulerException e) {
                e.printStackTrace();
                return Result.error("-10002", "暂停任务失败：" + e.getMessage());
            }

        }

        return Result.success("");
    }

    public Result delete(String jobId){
        QuartzJob quartzJob = quartzJobRepository.findOne(jobId);
        if(quartzJob == null){
            return Result.error("-10001", "任务不存在");
        }
        JobKey jobKey = JobKey.jobKey(quartzJob.getJobName(), quartzJob.getJobGroup());
        try {
            scheduler.deleteJob(jobKey);
            quartzJobRepository.delete(jobId);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return Result.success("");
    }
}
