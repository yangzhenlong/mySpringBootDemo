package com.mlxs.dao;


import com.mlxs.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserDao类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/21
 */
public interface UserDao extends JpaRepository<User, Long>{

    User findByUserName(String userName);
    User findByUserNameAndPassword(String userName, String password);
}
