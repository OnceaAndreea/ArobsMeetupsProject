package com.arobs.internship.arobs.meetups.service.user;

import com.arobs.internship.arobs.meetups.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserObject userObject;


    @Override
    public void addUser(UserDTO userDTO) {
        userObject.addUser(userDTO);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userObject.getAllUsers();
    }
}
