package com.arobs.internship.arobs.meetups.service;

import com.arobs.internship.arobs.meetups.entity.User;

import java.util.List;

public interface UserService {
    
    public void addUser(User users);

    public List<User> getAllUsers();
}
