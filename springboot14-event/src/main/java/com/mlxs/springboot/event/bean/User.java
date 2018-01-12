package com.mlxs.springboot.event.bean;


/**
 * User类描述: 用户
 *
 * @author yangzhenlong
 * @since 2018/1/12
 */
public class User {
    private int id;
    private String name;

    public User() {
    }

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
}
