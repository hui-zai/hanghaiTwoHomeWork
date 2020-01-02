package com.chen;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {

    @Autowired
    private WebApplicationContext WebApplicationContext;
    //定义一个mvc环境的伪造对象
    private MockMvc mockMvc;

    @Before
    public void beforeTest(){
        mockMvc = MockMvcBuilders.webAppContextSetup(WebApplicationContext).build();
    }

    @Test
    public void test1() throws Exception {
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.delete("/study1/3")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(contentAsString);
    }
}
