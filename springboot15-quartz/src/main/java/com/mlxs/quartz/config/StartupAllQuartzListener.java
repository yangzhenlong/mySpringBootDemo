package com.mlxs.quartz.config;


import com.mlxs.quartz.service.QuartzJobService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * StartupAllQuartzListener类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/24
 */
@Component
public class StartupAllQuartzListener {
    @Autowired
    private QuartzJobService service;
    @EventListener
    public void startALlQuart(StartupAllQuartzEvent event) throws SchedulerException {
        service.startAllJob();
    }
}
