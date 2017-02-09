package com.mlxs.springboot.porpertiesfile;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * properties类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/9
 */
@Component
public class TestProperties {

    @Value("${test.hello.world}")
    private String helloWorld;
    @Value("${test.person.name}")
    private String personName;
    @Value("${test.person.sex}")
    private String personSex;

    public String getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonSex() {
        return personSex;
    }

    public void setPersonSex(String personSex) {
        this.personSex = personSex;
    }
}
