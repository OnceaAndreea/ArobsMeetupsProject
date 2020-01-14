package com.arobs.internship.arobs.meetups.service.user;

import com.arobs.internship.arobs.meetups.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserObject userObject;

    @Override
    @Transactional
    public void addUser(UserDTO userDTO) {
        userObject.addUser(userDTO);
    }

    @Override
    @Transactional
    public List<UserDTO> getAllUsers() {
        return userObject.getAllUsers();
    }

    @Override
    @Transactional
    public UserDTO getUserById(int userId) {
       return userObject.getUserById(userId);
    }

    @Override
    @Transactional
    public void deleteUserById(int userId) {
        userObject.deleteUserById(userId);
    }

    @Override
    @Transactional
    public void updateUser(int userId,String lastName,String password,String email) {
    userObject.updateUser(userId,lastName,password,email);
    }

    @Override
    @Transactional
    public List<UserDTO> showLeaderBoard() {
        return userObject.showLeaderboard();
    }
}
