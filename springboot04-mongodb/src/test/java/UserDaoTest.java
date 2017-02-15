import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mlxs.springboot04.mongodb.bean.User;
import com.mlxs.springboot04.mongodb.dao.UserDao;
import com.mlxs.springboot04.mongodb.web.MainApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * UserDaoTest类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MainApp.class)
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAll() throws JsonProcessingException {
        this.add();
        this.delete();
        this.findByName();
        this.findByNameAndPhone();
        this.findAllBySexOrderByCreateTimeDesc();
    }

    @Test
    public void add() throws JsonProcessingException {
        System.out.println("--------------添加-------------");
        for(int i = 1; i <= 10; i++) {
            User user = new User();
            user.setName("测试" + i);
            user.setSex((i%2 == 0) ? 0 : 1);
            user.setPhone("1511111000" + i);
            user.setCreateTime(new Date());
            User save = userDao.save(user);
            System.out.println("保存结果：" + objectMapper.writeValueAsString(save));
        }
    }

    @Test
    public void delete() throws JsonProcessingException {
        System.out.println("--------------删除-------------");
        User user = userDao.findByName("测试6");
        userDao.delete(user);
        List<User> users = userDao.findAll();
        System.out.println("删除后的列表：" + objectMapper.writeValueAsString(users));
    }

    @Test
    public void findByName() throws JsonProcessingException {
        System.out.println("--------------findByName-------------");
        User user = userDao.findByName("测试1");
        System.out.println("findByName：" + objectMapper.writeValueAsString(user));
    }

    @Test
    public void findByNameAndPhone() throws JsonProcessingException {
        System.out.println("--------------findByNameAndPhone-------------");
        User user = userDao.findByNameAndPhone("测试1", "15111110001");
        System.out.println("findByNameAndPhone：" + objectMapper.writeValueAsString(user));
    }

    @Test
    public void findAllBySexOrderByCreateTimeDesc() throws JsonProcessingException {
        System.out.println("--------------findAllBySexByCreateTimeDesc-------------");
        List<User> userList = userDao.findAllBySexOrderByCreateTimeDesc(1);
        System.out.println("findAllBySexOrderByCreateTimeDesc：" + objectMapper.writeValueAsString(userList));
    }
}
