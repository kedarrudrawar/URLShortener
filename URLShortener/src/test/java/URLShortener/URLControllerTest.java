package URLShortener;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class URLControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void index() throws Exception{
        ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/")).andExpect((status().isOk()));
//        result.andDo(MockMvcResultHandlers.print());
        MvcResult mvcResult= result.andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }
}