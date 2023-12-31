package com.czc;

import com.czc.entity.User;
import com.czc.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {


    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {


        List<User>users= userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
