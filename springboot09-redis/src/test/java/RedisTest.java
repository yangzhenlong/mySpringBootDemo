import com.mlxs.springboot09.redis.MainApp;
import com.mlxs.springboot09.redis.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * RedisTest类描述:
 *
 * @author yangzhenlong
 * @since 2017/3/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApp.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        List<User> userList = User.buildUser();
        for(User user : userList) {
            redisTemplate.opsForValue().set("user" + user.getId(), user);
        }

        Object user1 = redisTemplate.opsForValue().get("user1");
        System.out.println("user1:" + user1);
    }
}
