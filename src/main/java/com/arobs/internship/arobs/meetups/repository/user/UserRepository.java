package com.arobs.internship.arobs.meetups.repository.user;

import com.arobs.internship.arobs.meetups.entity.User;

import java.util.List;

public interface UserRepository {

    void addUser(User user);

    List<User> getAllUsers();

    User getUserById(int userId);

    void deleteUser(User user);

}


