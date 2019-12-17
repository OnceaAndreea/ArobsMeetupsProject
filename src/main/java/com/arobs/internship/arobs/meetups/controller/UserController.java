package com.arobs.internship.arobs.meetups.controller;

import com.arobs.internship.arobs.meetups.entity.User;
import com.arobs.internship.arobs.meetups.service.user.UserDTO;
import com.arobs.internship.arobs.meetups.service.user.UserService;
import com.arobs.internship.arobs.meetups.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.persistence.Entity;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void create(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
    }

    @GetMapping("/Show_all_users")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

}