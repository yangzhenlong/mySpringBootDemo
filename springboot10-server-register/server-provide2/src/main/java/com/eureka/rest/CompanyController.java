package com.eureka.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController类描述:
 *
 * @author yangzhenlong
 * @since 2017/4/13
 */
@RestController()
public class CompanyController {

    private final static Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/server")
    public String client(){
        String description = discoveryClient.description();
        ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
        List<String> services = discoveryClient.getServices();
        StringBuffer sb = new StringBuffer();
        sb.append("discoveryClient描述：" + description);
        sb.append("\ndiscoveryClient本地服务HOST：" + localServiceInstance.getHost() + "---port：" + localServiceInstance.getPort() + "---serverId：" +localServiceInstance.getServiceId());
        sb.append("\ndiscoveryClient services：" + services);
        return "discoveryClient：" + sb.toString();
    }

    @RequestMapping("/{id}")
    public String get(@PathVariable String id){
        logCurrServerInfo();
        return "用户：" + id;
    }

    @RequestMapping("/add/{name}")
    public String add(@PathVariable String name){
        logCurrServerInfo();
        return "添加用户：" + name;
    }

    @RequestMapping("/getAll")
    public String add(){
        logCurrServerInfo();
        String s = "";
        for(int i=1; i<=5; i++){
            s = s + i + "测试测试" + System.currentTimeMillis() + "\n";
        }
        return "所有用户：" + s;
    }

    private void logCurrServerInfo(){
        LOGGER.info("当前服务信息------\n ServiceId:{}, \n Host:{}，\n Port:{}",
                discoveryClient.getLocalServiceInstance().getServiceId(),
                discoveryClient.getLocalServiceInstance().getHost(),
                discoveryClient.getLocalServiceInstance().getPort()
                );
    }
}
