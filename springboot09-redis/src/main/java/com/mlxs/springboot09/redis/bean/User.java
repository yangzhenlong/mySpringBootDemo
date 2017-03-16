package com.mlxs.springboot09.redis.bean;


import java.util.ArrayList;
import java.util.List;

/**
 * User类描述:
 *
 * @author yangzhenlong
 * @since 2017/3/16
 */
public class User {

    private int id;
    private String name;
    private int age;
    private Company company;
    private String mobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", company=" + company +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public static List<User> buildUser(){
        List<User> users = new ArrayList<>(5);
        for(int i = 1; i <= 5; i++) {
            User user = new User();

            user.setId(i);
            user.setAge(i + 20);
            user.setName("用户" + i);
            user.setMobile("1511111000"+ i);

            Company company = new Company();
            company.setId(11 - i);
            company.setName("公司" + (11 -i));
            company.setAddress("杭州西湖" + (11 - i));
            user.setCompany(company);
            users.add(user);
        }
        return users;
    }
}
