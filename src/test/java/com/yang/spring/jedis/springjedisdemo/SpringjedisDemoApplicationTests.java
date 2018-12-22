package com.yang.spring.jedis.springjedisdemo;

import com.yang.spring.jedis.springjedisdemo.controller.UserController;
import com.yang.spring.jedis.springjedisdemo.service.UserService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringjedisDemoApplication.class)
public class SpringjedisDemoApplicationTests {

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Autowired
    public UserService userService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Before
    public void setUp() {
        userController.userService = userService;
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void contextLoads() {
        try {
            mockMvc.perform(get("/user/all/1/2")).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(redisTemplate.boundValueOps("demo").get());
    }

}

