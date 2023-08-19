package com.czc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.czc.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface UserService extends IService<User> {
    Map<String, Object> login(User user);
}
