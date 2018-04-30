package com.example.service.swap.rest;

import com.example.service.swap.entity.User;
import com.example.service.swap.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UsersRestController {
    @Resource
    private UserService userService;

    @GetMapping("/users")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @PostMapping("/user/{id}")
    @CrossOrigin(origins = "http://localhost:3000/delete-user/{id}")
    public List<User> deleteUser(@PathVariable int id){
        System.out.println("ID = " + id);
        User user = userService.findAll().remove(id);
        System.out.println("deleted = " + user);
        return userService.findAll();
    }


}
