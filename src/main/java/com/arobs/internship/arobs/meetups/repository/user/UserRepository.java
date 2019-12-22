package com.arobs.internship.arobs.meetups.repository.user;

import com.arobs.internship.arobs.meetups.configuration.DataBaseConnection;
import com.arobs.internship.arobs.meetups.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserRepository {

    void addUser(User user);

    List<User> getAllUsers();

    User getUserById(int userId);


}


