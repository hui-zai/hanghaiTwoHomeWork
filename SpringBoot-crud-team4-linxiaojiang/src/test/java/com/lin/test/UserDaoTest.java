package com.lin.test;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;


    @Before
    public void setUp(){
        mvc= MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testPut() throws Exception {
        String content="{\"id\":2,\"username\":\"Kate\",\"email\":\"six@163.com\",\"sex\":\"女\",\"province\":\"北京市\",\"hobby\":[\"读书\",\"绘画\"]}";

        String get = mvc.perform(put("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(get);


    }



    @Test
    public void testDelete() throws Exception {

        String content = mvc.perform(delete("/user/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(content);


    }


    @Test
    public void testPost() throws Exception {
        String content="{\"id\":null,\"username\":\"Kate\",\"email\":\"222@qq.com\",\"sex\":\"女\",\"province\":\"北京市\",\"hobby\":[\"读书\",\"棒球\"]}";

        String get = mvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(get);
    }

    @Test
    public void testGet() throws Exception {
        String get = mvc.perform(get("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(get);
    }


}
