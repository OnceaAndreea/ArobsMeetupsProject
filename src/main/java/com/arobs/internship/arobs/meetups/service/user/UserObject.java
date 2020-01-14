package com.arobs.internship.arobs.meetups.service.user;

import com.arobs.internship.arobs.meetups.entity.User;
import com.arobs.internship.arobs.meetups.repository.user.UserRepository;
import com.arobs.internship.arobs.meetups.repository.user.UserRepositoryConstants;
import com.arobs.internship.arobs.meetups.repository.user.UserRepositoryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserObject {


    @Autowired
    UserRepositoryFactory userRepositoryFactory;

    @Autowired
    UserMapper userMapper;

    //receive DTO
    public void addUser(UserDTO userDTO) {
        UserRepository userRepository = userRepositoryFactory.createUserRepository(UserRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
        if (userDTO != null) {
            User user = userMapper.map(userDTO, User.class);
            userRepository.addUser(user);
        }
    }

    //send DTOs
    public List<UserDTO> getAllUsers() {
        UserRepository userRepository = userRepositoryFactory.createUserRepository(UserRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
        List<User> users = userRepository.getAllUsers();
        if (users != null) {
            return userMapper.mapAsList(users, UserDTO.class);
        }
        return null;
    }

    public UserDTO getUserById(int userId) {
        UserRepository userRepository = userRepositoryFactory.createUserRepository(UserRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
        User user = userRepository.getUserById(userId);
        if (user != null) {
            return userMapper.map(user, UserDTO.class);
        }
        return null;
    }

    public void deleteUserById(int userId) {
        UserRepository userRepository = userRepositoryFactory.createUserRepository(UserRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
        User user = userRepository.getUserById(userId);
        if (user!=null){
            userRepository.deleteUser(user);
        }
    }
    public void updateUser(int userId,String lastName,String password,String email){
        UserRepository userRepository = userRepositoryFactory.createUserRepository(UserRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
        User user = userRepository.getUserById(userId);
        if(user!=null){
            user.setLastName(lastName);
            user.setPassword(password);
            user.setEmail(email);
            userRepository.addUser(user);
        }
    }


}
