package com.mlxs.security.config;


import com.mlxs.bean.User;
import com.mlxs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


/**
 * MyUDService类描述: 用户服务类，用来从读取用户信息
 *
 * @author yangzhenlong
 * @since 2017/5/22
 */
@Component
public class MyUDService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByUserName(s);
        if(user == null) {
            throw new UsernameNotFoundException("UserName " + s + " not found");
        }

        System.out.println("用户" + s + "：" + user);
        return user;
    }
}
