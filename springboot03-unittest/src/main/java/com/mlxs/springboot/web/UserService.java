package com.mlxs.springboot.web;


import com.mlxs.springboot.dto.User;

import java.util.Map;

/**
 * UserService接口描述:
 *
 * @author yangzhenlong
 * @since 2017/2/13
 */
public interface UserService {


    /**
     * 查询所有用户
     * @return
     */
    Map<Integer, User> getAllUsers();

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 更新
     * @param user
     * @return
     */
    User updateUserById(User user);

    /**
     * 添加
     * @param user
     * @return
     */
    User addUser(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean deleteUser(Integer id);
}
