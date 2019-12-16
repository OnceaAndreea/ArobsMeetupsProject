package com.arobs.internship.arobs.meetups.service.user;

import com.arobs.internship.arobs.meetups.entity.User;

import java.util.List;

public interface UserService {
    
    public void addUser(UserDTO userDTO);

    public List<UserDTO> getAllUsers();
}
