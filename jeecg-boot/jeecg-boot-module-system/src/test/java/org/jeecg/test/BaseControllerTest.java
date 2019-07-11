package org.jeecg.test;

import org.jeecg.TestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestApplication.class})
@AutoConfigureMockMvc
public class BaseControllerTest {

    @Autowired
    protected MockMvc mvc;


    /*@Test
    public void userLogin3_0() throws Exception {
        String responseString = this.mvc.perform(post("/webservice/passenger/loginV30")
                .param("code", "9810")
                .params(loginParams)
                .headers(httpHeaders)

        ).andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

        System.out.println(responseString);
    }*/
}
