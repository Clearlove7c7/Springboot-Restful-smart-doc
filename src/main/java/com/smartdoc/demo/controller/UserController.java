package com.smartdoc.demo.controller;

import com.smartdoc.demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title： demo
 * @Description： TODO
 * @Author： Zhaolc
 * @Date： 2019/7/5 15:48
 */
@RestController
public class UserController {

    /**
     * 新增用户
     * @param user 用户实体类
     */
    @PostMapping("/add")
    public void addUser(User user){
        System.out.println("新增一个用户");

    }

    /**
     * 查询一个用户
     * @param id 用户id
     * @return
     */
    @GetMapping
    public User getUser(int id){
        User user = new User();
        user.setAccount("admin");
        user.setPassword("123456");
        user.setAge(18);
        return user;
    }

}
