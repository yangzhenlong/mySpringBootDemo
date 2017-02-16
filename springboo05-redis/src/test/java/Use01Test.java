import com.mlxs.springboot05.redis.MainApp;
import com.mlxs.springboot05.redis.use01.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Use01Test类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MainApp.class)
public class Use01Test {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test(){
        //设置值
        List<String> stringList = Arrays.asList("aaa", "bbb", "ccc");
        boolean setResult = redisUtil.set("strList", stringList);
        System.out.println("保存redis结果：" + setResult);

        //获取值
        Object getResult = redisUtil.get("strList");
        System.out.println("查询redis结果：" + getResult);
    }
}
