package com.mlxs.springboot13;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * MsgReceiver类描述:
 *
 * @author yangzhenlong
 * @since 2017/8/10
 */
@Component
@RabbitListener(queues = "first")
public class MsgReceiver {
    @RabbitHandler
    public void process(String res) {
        System.out.println("--------------------接受信息 ------------------: " + res);
    }
}
