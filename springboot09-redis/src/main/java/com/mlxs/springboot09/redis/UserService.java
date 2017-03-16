package com.mlxs.springboot09.redis;


import com.mlxs.springboot09.redis.bean.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService类描述:
 *
 * @author yangzhenlong
 * @since 2017/3/16
 */
@Service
public class UserService {

    @Cacheable(value = "userCache", keyGenerator = "keyGenerator")//设置redis 和
    public List<User> users(){
        return User.buildUser();
    }
}
