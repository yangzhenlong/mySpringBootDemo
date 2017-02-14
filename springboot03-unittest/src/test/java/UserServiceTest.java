import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mlxs.springboot.dto.User;
import com.mlxs.springboot.web.MainApp;
import com.mlxs.springboot.web.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * UserWebTest类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MainApp.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private ObjectMapper om;

    @Test
    public void testAll() throws JsonProcessingException {
        this.list();
        this.add();
        this.update();
        this.delete();
    }

    @Test
    public void list() throws JsonProcessingException {
        System.out.println("\n----------查询----------");
        this.print(userService.getAllUsers());
    }

    @Test
    public void add(){
        System.out.println("\n----------添加----------");
        User add = new User();
        add.setId(10);
        add.setName("这是新添加");
        userService.addUser(add);
        this.print(userService.getAllUsers());
    }

    @Test
    public void update(){
        System.out.println("\n----------更新----------");
        User user = userService.getUserById(2);
        user.setName("测试222");
        userService.updateUserById(user);
        this.print(userService.getAllUsers());
    }

    @Test
    public void delete(){
        System.out.println("\n----------删除----------");
        userService.deleteUser(3);
        this.print(userService.getAllUsers());
    }

    private void print(Object obj){
        try {
            System.out.println(om.writeValueAsString(obj));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
