import com.mlxs.quartz.Constants;
import com.mlxs.quartz.StartApp;
import com.mlxs.quartz.bean.JobClass;
import com.mlxs.quartz.bean.QuartzJob;
import com.mlxs.quartz.config.QuartzManager;
import com.mlxs.quartz.dao.JobClassRepository;
import com.mlxs.quartz.dao.QuartzJobRepository;
import com.mlxs.quartz.job.HelloJob;
import com.mlxs.quartz.job.SecondJob;
import com.mlxs.quartz.service.QuartzJobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * TestHelloJob类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(StartApp.class)
public class TestHelloJob {
    @Resource(name = "scheduler")
    private Scheduler scheduler;
    @Autowired
    private QuartzManager quartzManager;
    @Autowired
    private QuartzJobRepository quartzJobRepository;
    @Autowired
    private JobClassRepository jobClassRepository;

    @Test
    public void addJob(){
        List<QuartzJob> list = new ArrayList<>();
        for(int i=1;i<=3;i++){
            QuartzJob job = new QuartzJob();
            job.setId(i+"");
            job.setJobName("Test_Job_" + i);
            job.setJobGroup(Constants.DEFAULT_JOB_GROUP);
            job.setTriggerName("Test_Trigger_" + i);
            job.setTriggerGroup(Constants.DEFAULT_TRIGGER_GROUP);
            job.setCronExpression("0/"+i+" * * * * ?");//i秒执行一次
            job.setFullClass("com.mlxs.quartz.job.MyJob"+i);
            job.setStatus("0");
            list.add(job);
        }
        quartzJobRepository.save(list);

        for(int i=1;i<=5;i++){
            JobClass jc = new JobClass();
            jc.setId(i+"");
            jc.setFullClass("com.mlxs.quartz.job.MyJob"+i);
            jobClassRepository.save(jc);
        }
    }

    @Test
    public void testHelloJob() throws SchedulerException, InterruptedException {
        //定时器1
        System.out.println("-------------hello job start-----------------");
        JobDetail jd1 = quartzManager.createJobDetail("job1", "job_group_1", HelloJob.class);
        jd1.getJobDataMap().put("params", "this is params");
        CronTrigger trigger1 = quartzManager.createTrigger("trigger1", "trigger_group_1", "0/2 * * * * ? ");
        scheduler.scheduleJob(jd1, trigger1);
        Thread.sleep(5000);

        //定时器2
        System.out.println("-------------second job start-----------------");
        JobDetail jd2 = quartzManager.createJobDetail("job2", "job_group_2", SecondJob.class);
        CronTrigger trigger2 = quartzManager.createTrigger("trigger2", "trigger_group_2", "0/3 * * * * ? ");
        scheduler.scheduleJob(jd2, trigger2);

        Thread.sleep(10000);
        //暂停1
        System.out.println("job1 暂停...");
        scheduler.pauseJob(JobKey.jobKey("job1", "job_group_1"));

        Thread.sleep(10000);
        //恢复1
        System.out.println("job1 恢复运行...");
        scheduler.resumeJob(JobKey.jobKey("job1", "job_group_1"));
        Thread.sleep(5000);

        System.out.println("");
        System.out.println("---------end----------");
    }
}
