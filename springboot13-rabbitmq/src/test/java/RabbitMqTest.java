import com.mlxs.springboot13.MsgSend;
import com.mlxs.springboot13._13App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * RabbitMqTest类描述:
 *
 * @author yangzhenlong
 * @since 2017/8/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = _13App.class)
public class RabbitMqTest {
    @Autowired
    private MsgSend sender;
    @Test
    public void hello() throws Exception {
        sender.send();
    }
}
