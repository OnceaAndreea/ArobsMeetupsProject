package com.arobs.internship.arobs.meetups.service.user;

import com.arobs.internship.arobs.meetups.entity.User;
import com.arobs.internship.arobs.meetups.repository.user.UserRepository;
import com.arobs.internship.arobs.meetups.repository.user.UserRepositoryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserObject {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRepositoryFactory userRepositoryFactory;
    @Autowired
    UserMapper userMapper;

    //receive DTO
    public void addUser(UserDTO userDTO){
        User user=userMapper.map(userDTO,User.class);
        userRepository.addUser(user);
    }

    //send DTOs
    public List<UserDTO> getAllUsers(){
        List<User>users= userRepository.getAllUsers();
        if (users!=null){
            return userMapper.mapAsList(users, UserDTO.class);
        }
        return null;
    }

}
