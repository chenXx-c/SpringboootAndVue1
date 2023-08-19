package com.czc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.czc.config.MyRedisConfig;
import com.czc.entity.User;
import com.czc.mapper.UserMapper;
import com.czc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>implements UserService {
    @Resource
    private RedisTemplate redisTemplate;

   @Autowired
   private UserMapper userMapper;
    @Override
    public Map<String, Object> login(User user) {


        //查询
        LambdaQueryWrapper<User>queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername());
        queryWrapper.eq(User::getPassword,user.getPassword());
        User loginUser = userMapper.selectOne(queryWrapper);


        //结果不为空生成token
        if(loginUser!=null){
            //暂时用uuid，终极方案jwt
            String key="user"+ UUID.randomUUID();

          // 存入redis
//            loginUser.setPassword(null);
//            redisTemplate.opsForValue().set(key, loginUser, 30, TimeUnit.MINUTES);



            HashMap<String, Object> data = new HashMap<>();
            data.put("token",key);
            return data;

        }



        return null;
    }
}
