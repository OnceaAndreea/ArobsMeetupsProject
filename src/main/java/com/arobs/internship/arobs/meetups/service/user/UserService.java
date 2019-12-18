package com.arobs.internship.arobs.meetups.service.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    
    public void addUser(UserDTO userDTO);

    public List<UserDTO> getAllUsers();
}
