package com.mlxs.springboot.dto;


import java.util.HashMap;
import java.util.Map;

/**
 * User类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/13
 */
public class User {

    private int id;
    private String name;

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

    public static Map<Integer, User> buildUserList(){
        Map<Integer, User> userMap = new HashMap<>();

        for(int i=1; i<=5; i++){
            User user = new User();
            user.setId(i);
            user.setName("测试" + i);
            userMap.put(i, user);
        }

        return userMap;
    }
}
