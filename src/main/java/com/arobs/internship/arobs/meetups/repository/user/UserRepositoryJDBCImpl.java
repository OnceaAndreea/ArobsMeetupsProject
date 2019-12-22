package com.arobs.internship.arobs.meetups.repository.user;

import com.arobs.internship.arobs.meetups.configuration.DataBaseConnection;
import com.arobs.internship.arobs.meetups.entity.User;
import com.arobs.internship.arobs.meetups.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryJDBCImpl implements UserRepository {

    @Autowired
    DataBaseConnection dataBaseConnection;

    public void addUser(User user) {

        String sql = " Insert into users (firstName,lastName,password,role,email,points)"
                + " values (?, ?, ?, ?, ?)";

        try (Connection con = dataBaseConnection.getDs().getConnection()) {

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getLastName());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getRole());
            pst.setInt(5, user.getPoints());
            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        String sql = "Select * from users";

        try (Connection con = dataBaseConnection.getDs().getConnection()) {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                int userId = rs.getInt("ItemId");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String email = rs.getString("email");
                int points = rs.getInt("points");

                User user = new User(userId, firstName, lastName, password, role, email, points);

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUserById(int userId) {
        return null;
    }
}
