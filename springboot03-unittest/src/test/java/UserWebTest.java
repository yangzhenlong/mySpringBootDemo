import com.mlxs.springboot.web.UserController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * UserWebTest类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MockServletContext.class)
@WebAppConfiguration //启动一个真实web服务，然后调用Controller的Rest API，待单元测试完成之后再将web服务停掉
public class UserWebTest {

    private MockMvc mockMvc;

    @Before
    public void setMockMvc(){
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();//设置要mock的Controller类，可以是多个
    }

    @Test
    public void testAll() throws Exception {
        //1.查询
        String queryResult = mockMvc.perform(MockMvcRequestBuilders.get("/user"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("id")))
                .andReturn().getResponse().getContentAsString();
        System.out.println("----------查询----------\n" + queryResult);
        //2.添加
        String addResult = mockMvc.perform(MockMvcRequestBuilders.post("/user").param("id", "10").param("name", "新添加"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println("----------添加----------\n" + addResult);
        //3.更新
        String updateResult = mockMvc.perform(MockMvcRequestBuilders.put("/user").param("id", "3").param("name", "更新333"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println("----------更新----------\n" + updateResult);
        //4.删除
        String deleteResult = mockMvc.perform(MockMvcRequestBuilders.delete("/user").param("id", "1"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println("----------删除----------\n" + deleteResult);
    }
}
