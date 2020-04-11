package newsplatform;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = App.class
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class AppTests {
    @Autowired
    MockMvc mockMvc;
    @Test
    public void contextLoads() throws Exception{

        MvcResult mvcResult=mockMvc.perform(
                MockMvcRequestBuilders.get("/getAllUsers").
                        accept(MediaType.APPLICATION_JSON)).andReturn();

        System.out.println(mvcResult.getResponse());
        MvcResult mvcResult1=mockMvc.perform(
                MockMvcRequestBuilders.get("/signUp").
                        accept(MediaType.APPLICATION_JSON)).andReturn();

        System.out.println(mvcResult1.getResponse());

        MvcResult mvcResult2=mockMvc.perform(
                MockMvcRequestBuilders.get("/page/1").
                        accept(MediaType.APPLICATION_JSON)).andReturn();

        System.out.println(mvcResult2.getResponse());

        MvcResult mvcResult3=mockMvc.perform(
                MockMvcRequestBuilders.get("/news/1").
                        accept(MediaType.APPLICATION_JSON)).andReturn();

        System.out.println(mvcResult3.getResponse());

        MvcResult mvcResult4=mockMvc.perform(
                MockMvcRequestBuilders.get("/news/1/comment").
                        accept(MediaType.APPLICATION_JSON)).andReturn();

        System.out.println(mvcResult.getResponse());
        MvcResult mvcResult5=mockMvc.perform(
                MockMvcRequestBuilders.get("/postNews").
                        accept(MediaType.APPLICATION_JSON)).andReturn();

        System.out.println(mvcResult5.getResponse());

        MvcResult mvcResult6=mockMvc.perform(
                MockMvcRequestBuilders.get("/delete/news/1").
                        accept(MediaType.APPLICATION_JSON)).andReturn();

        System.out.println(mvcResult6.getResponse());

        MvcResult mvcResult7=mockMvc.perform(
                MockMvcRequestBuilders.get("/delete/user/1").
                        accept(MediaType.APPLICATION_JSON)).andReturn();

        System.out.println(mvcResult7.getResponse());

    }

}
