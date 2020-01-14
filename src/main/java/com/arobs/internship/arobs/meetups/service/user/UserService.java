package com.arobs.internship.arobs.meetups.service.user;

import com.arobs.internship.arobs.meetups.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    
    public void addUser(UserDTO userDTO);

    public List<UserDTO> getAllUsers();

    public UserDTO getUserById(int userId);

    public void deleteUserById(int userId);

    public void updateUser(int userId,String lastName,String password,String email);
}
