package com.mlxs.springboot.porpertiesfile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PropertiesController类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/9
 */
@RestController
public class PropertiesController {
    @Autowired
    TestProperties testProperties;

    @RequestMapping("/properties")
    public String[] getProperties(){
        String[] result = {"hello:" + testProperties.getHelloWorld(),
                "name:" + testProperties.getPersonName(),
                "sex:" + testProperties.getPersonSex()};

        return result;
    }
}
