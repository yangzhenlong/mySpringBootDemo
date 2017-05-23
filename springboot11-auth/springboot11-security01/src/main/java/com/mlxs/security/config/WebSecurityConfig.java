package com.mlxs.security.config;


import com.mlxs.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * WebSecurityConfig类描述:
 *
 * @author yangzhenlong
 * @since 2017/5/18
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)//允许进入页面方法前检验
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeRequests()
                .antMatchers("/", "/login").permitAll() //无需验证权限
                .anyRequest().authenticated() //其他地址的访问均需验证权限
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/home").permitAll()//指定登录页是"/login" //登录成功后默认跳转到"/home"
                .and().logout().logoutSuccessUrl("/login").permitAll(); //退出登录后的默认url是"/login"
    }

    /**
     * 全局配置
     * @param builder
     * @throws Exception
     */
    @Autowired
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder
                .userDetailsService(this.myUDService())
                .passwordEncoder(this.passwordEncoder());
        //或者用下面的方式，直接配置固定的用户和对应的角色
        /*builder.inMemoryAuthentication().withUser("test").password("1234").roles("USER");
        builder.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        builder.inMemoryAuthentication().withUser("dba").password("root").roles("ADMIN","DBA");*/
    }

    /**
     * 设置用户密码的加密方式：MD5加密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder pe = new PasswordEncoder() {//自定义密码加密方式
            //加密
            @Override
            public String encode(CharSequence charSequence) {
                return MD5Util.encode((String)charSequence);
            }

            //校验密码
            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return MD5Util.encode((String)charSequence).equals(s);
            }
        };
        return pe;
    }

    /**
     * 自定义用户服务，获取用户信息
     * @return
     */
    @Bean
    public MyUDService myUDService(){
        return new MyUDService();
    }
}
