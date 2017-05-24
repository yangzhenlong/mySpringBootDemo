package com.mlxs.security.config;


import com.mlxs.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启进入Controller之前，检验权限。这个注解配置后，Controller中的@PreAuthorize("hasAnyAuthority('ADMIN')")才会生效
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private MyUDService myUDService;
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeRequests()
                .antMatchers("/", "/login", "/err/*").permitAll() //无需验证权限
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
                .userDetailsService(myUDService)
                .passwordEncoder(this.passwordEncoder());
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
}
