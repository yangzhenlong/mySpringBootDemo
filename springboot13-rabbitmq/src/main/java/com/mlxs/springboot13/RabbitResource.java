package com.mlxs.springboot13;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RabbitResource类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/29
 */
@RestController
public class RabbitResource {
    @Autowired
    private MsgSend msgSend;

    @RequestMapping("/send")
    public String send(String msg){
        return msgSend.send(msg);
    }
}
