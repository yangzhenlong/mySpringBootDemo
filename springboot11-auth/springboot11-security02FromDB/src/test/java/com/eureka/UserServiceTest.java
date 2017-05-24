package com.eureka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mlxs.Start02App;
import com.mlxs.bean.User;
import com.mlxs.dao.UserDao;
import com.mlxs.service.UserService;
import com.mlxs.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * ServiceTest类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Start02App.class)
public class UserServiceTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testAll() throws JsonProcessingException {

        this.saveUser();
        this.list();

    }

    private void saveUser() throws JsonProcessingException {
        User admin = new User();
        admin.setUserName("admin");
        admin.setPassword(MD5Util.encode("admin"));
        admin.setPwdBak("admin");
        admin.setRole("ADMIN");
        User adminSave = userDao.save(admin);
        for(int i=0;i<=5;i++) {
            System.out.println("admin save--->:" + objectMapper.writeValueAsString(adminSave));
            User user = new User();
            user.setUserName("test"+i);
            user.setPassword(MD5Util.encode("user" + i));
            user.setPwdBak("user" + i);
            user.setRole("USER");
            User userSave = userDao.save(user);
            System.out.println("user save--->:" + objectMapper.writeValueAsString(userSave));
        }
    }

    private void list() throws JsonProcessingException {
        List<User> userList = userService.userList();
        System.out.println("用户列表：" + objectMapper.writeValueAsString(userList));
    }

}
