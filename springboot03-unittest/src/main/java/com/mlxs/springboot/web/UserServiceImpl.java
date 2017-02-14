package com.mlxs.springboot.web;


import com.mlxs.springboot.dto.User;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * UserServiceImpl类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/13
 */
@Service
public class UserServiceImpl implements UserService{

    private static Map<Integer, User> userMap = User.buildUserList();

    /**
     * 查询所有用户
     * @return
     */
    public Map<Integer, User> getAllUsers(){
        return userMap;
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public User getUserById(Integer id){
        return userMap.get(id);
    }

    /**
     * 更新
     * @param user
     * @return
     */
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
    public boolean deleteUser(Integer id){
        if(null == userMap.get(id)){
            throw new RuntimeException("用户不存在");
        }
        userMap.remove(id);
        return true;
    }
}
