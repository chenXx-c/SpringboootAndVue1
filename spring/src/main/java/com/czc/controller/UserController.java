package com.czc.controller;

import com.czc.common.Result;
import com.czc.entity.User;
import com.czc.service.UserService;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Result<List<User>>findAll(){
        List<User> list = userService.list();
        return Result.success(list,"查询成功");

    }
    @PostMapping("/login")
    public Result<Map<String,Object>>login(@RequestBody User user){
       Map<String, Object>data= userService.login(user);
        if(data!=null){

        return Result.success(data);
        }

        return Result.fail(2002,"用户名或者密码错误");
    }


    @GetMapping("/info")
    public Result<?>getUserInfo(@RequestParam("token")String token){


    }


}
