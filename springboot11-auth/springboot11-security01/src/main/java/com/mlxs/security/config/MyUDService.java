package com.mlxs.security.config;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * MyUDService类描述: 用户服务类，用来从读取用户信息
 *
 * @author yangzhenlong
 * @since 2017/5/22
 */
public class MyUDService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if(s.equals("admin")) {
            List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

            User user = new User("admin", "66d4aaa5ea177ac32c69946de3731ec0", authorities);//用户名和通过MD5加密后的密码
            return user;
        }else{
            throw new UsernameNotFoundException("UserName " + s + " not found");
        }
    }


}
