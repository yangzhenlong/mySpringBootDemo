package com.mlxs.springboot.event.event;


import com.mlxs.springboot.event.bean.User;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * UserRegisterEventListener类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/12
 */
@Component
public class UserRegisterEventListener {

    @EventListener
    public void register(UserRegisterEvent event){
        User user = event.getUser();
        System.out.println("-----------监听到用户注册事件------,给用户【" + user.getName() + "】发送短信...");
    }
}
