package com.mlxs.springboot.event.event;


import com.mlxs.springboot.event.bean.User;
import org.springframework.context.ApplicationEvent;

/**
 * UserRegisterEvent类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/12
 */
public class UserRegisterEvent extends ApplicationEvent {
    private Object source;
    private User user;
    public UserRegisterEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    @Override
    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
