package com.mlxs.quartz.config;


import com.mlxs.quartz.service.QuartzJobService;
import org.springframework.context.ApplicationEvent;

/**
 * ApplicationStartup类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/24
 */
public class StartupAllQuartzEvent extends ApplicationEvent{
    private Object source;
    public StartupAllQuartzEvent(Object source) {
        super(source);
    }

    @Override
    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }
}
