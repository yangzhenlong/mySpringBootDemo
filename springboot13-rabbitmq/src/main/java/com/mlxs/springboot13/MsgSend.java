package com.mlxs.springboot13;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * MsgSend类描述:
 *
 * @author yangzhenlong
 * @since 2017/8/10
 */
@Component
public class MsgSend {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send() {
        String context = "你好, time=" + System.currentTimeMillis();
        System.out.println("发送内容 : " + context);
        this.rabbitTemplate.convertAndSend("first", context);
        this.rabbitTemplate.convertAndSend("first", context+"2");
        this.rabbitTemplate.convertAndSend("first", context+"3");
    }
}