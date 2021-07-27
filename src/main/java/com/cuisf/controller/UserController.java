package com.cuisf.controller;

import com.cuisf.mapper.UserMapper;
import com.cuisf.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/userList")
    public List<User> userList(){

        List<User> userList = userMapper.queryUserList();

        userList.forEach(e -> System.out.println(e));
        return userList;
    }


    @GetMapping("/user/{id}")
    public User queryUserById(@PathVariable("id") Integer id){

        return userMapper.queryUserById(id);
    }


    @GetMapping("/updateUser")
    public String updateUser(User user){

        userMapper.updateUser(user);

        return "update-ok";
    }

    @GetMapping("/addUser")
    public String addUser(User user){

        user.setId(14);
        user.setName("honger");
        user.setPwd("123456");


        userMapper.addUser(user);

        return "add-ok";
    }


    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id){

         userMapper.deleteUser(14);
        return "delete-ok";
    }

}
