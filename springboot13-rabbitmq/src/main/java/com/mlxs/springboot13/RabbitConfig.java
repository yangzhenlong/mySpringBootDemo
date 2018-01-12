package com.mlxs.springboot13;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitConfig类描述:
 *
 * @author yangzhenlong
 * @since 2017/8/10
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue firstQueue(){
        return new Queue("first");
    }

    @Bean
    public AmqpTemplate rabbitTemplate(){
        return new RabbitTemplate();
    }
}
