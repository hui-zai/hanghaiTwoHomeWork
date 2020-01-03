package com.joey;

import com.joey.dao.UserDao;
import com.joey.pojo.User;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Autowired
    private UserDao userdao;

    @Before
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void test1() throws Exception{
        List<String> hobby= new ArrayList<String>();
        hobby.add("游泳");
        hobby.add("羽毛球");

        User user = new User(null,"kwok","jiey","8493@qq.com","男","广东",hobby);
        userdao.save(user);
        System.out.println("添加成功");
    }

    /**
     * 查询所有
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{

        List<User> users = userdao.findAll();
        System.out.println(users.toString());
    }

    /**
     * 修改
     * @throws Exception
     */
    @Test
    public void test3() throws Exception{



    }
}
