package com.arobs.internship.arobs.meetups.service;

import com.arobs.internship.arobs.meetups.entity.User;
import com.arobs.internship.arobs.meetups.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserObject {

    @Autowired
    UserRepo userRepo;

    public void addUser(User user){
        userRepo.addUser(user);
    }

    public List<User> getAllUsers(){
       return userRepo.getAllUsers();
    }

}
