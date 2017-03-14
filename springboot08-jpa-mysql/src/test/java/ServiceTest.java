import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mlxs.springboot08.jpa.mysql.MainApp;
import com.mlxs.springboot08.jpa.mysql.bean.User;
import com.mlxs.springboot08.jpa.mysql.dao.UserDao;
import com.mlxs.springboot08.jpa.mysql.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@SpringBootTest(classes = MainApp.class)
public class ServiceTest {

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
        admin.setPassword("admin");
        User adminSave = userDao.save(admin);
        System.out.println("admin save--->:" + objectMapper.writeValueAsString(adminSave));
        User user = new User();
        user.setUserName("user");
        user.setPassword("user");
        User userSave = userDao.save(user);
        System.out.println("user save--->:" + objectMapper.writeValueAsString(userSave));
    }

    private void list() throws JsonProcessingException {
        List<User> userList = userService.userList();
        System.out.println("用户列表：" + objectMapper.writeValueAsString(userList));
    }

}
