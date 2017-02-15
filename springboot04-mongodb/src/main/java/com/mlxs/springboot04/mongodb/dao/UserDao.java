package com.mlxs.springboot04.mongodb.dao;


import com.mlxs.springboot04.mongodb.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * UserDao类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/14
 */
public interface UserDao extends MongoRepository<User, String> {

    User findByName(String name);//根据name查询

    User findByNameAndPhone(String name, String phone);

    List<User> findAllBySexOrderByCreateTimeDesc(Integer sex);//根据性别查询，并根据创建时间倒序

}
