package com.arobs.internship.arobs.meetups.service.user;

import com.arobs.internship.arobs.meetups.entity.User;
import com.arobs.internship.arobs.meetups.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserObject {

    @Autowired
    UserRepo userRepo;
    @Autowired
    UserMapper userMapper;

    //receive DTO
    public void addUser(UserDTO userDTO){
        User user=userMapper.map(userDTO,User.class);
        userRepo.addUser(user);
    }

    //send DTOs
    public List<UserDTO> getAllUsers(){
        List<User>users=userRepo.getAllUsers();
        if (users!=null){
            return userMapper.mapAsList(users, UserDTO.class);
        }
        return null;
    }

}
