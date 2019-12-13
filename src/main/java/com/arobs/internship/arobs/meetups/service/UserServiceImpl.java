package com.arobs.internship.arobs.meetups.service;

import com.arobs.internship.arobs.meetups.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserObject userObject;


    @Override
    public void addUser(User user) {
        userObject.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userObject.getAllUsers();
    }
}
