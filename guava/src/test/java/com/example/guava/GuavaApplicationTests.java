package com.example.guava;

import com.example.guava.user.User;
import com.example.guava.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuavaApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setId(1);
        user.setName("18989889898");
        user.setPassword("asfsfsfsfsfa12313");
        userService.insert(user);
        User result = userService.get("18989889898");

        System.out.println(result);
    }

}
