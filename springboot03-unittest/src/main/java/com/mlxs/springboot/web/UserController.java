package com.mlxs.springboot.web;


import com.mlxs.springboot.dto.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * UserController类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/13
 */
@RestController()
@RequestMapping("/")
public class UserController {

    private static Map<Integer, User> userMap = User.buildUserList();

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Map<Integer, User> getAllUsers(){
        return userMap;
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(Integer id){
        return userMap.get(id);
    }

    /**
     * 更新
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User updateUserById(User user){
        if(null == userMap.get(user.getId())){
            throw new RuntimeException("用户不存在");
        }
        userMap.put(user.getId(), user);
        return user;
    }

    /**
     * 添加
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User addUser(User user){
        if(null != userMap.get(user.getId())){
            throw new RuntimeException("用户已存在");
        }
        userMap.put(user.getId(), user);
        return user;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser(Integer id){
        if(null == userMap.get(id)){
            throw new RuntimeException("用户不存在");
        }
        userMap.remove(id);
        return "delete success";
    }
}
