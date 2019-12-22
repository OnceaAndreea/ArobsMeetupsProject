package com.arobs.internship.arobs.meetups.repository.user;

import com.arobs.internship.arobs.meetups.configuration.DataBaseConnection;
import com.arobs.internship.arobs.meetups.entity.User;
import com.arobs.internship.arobs.meetups.repository.user.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryHibernateImpl implements UserRepository {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void addUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        Query query = currentSession.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public User getUserById(int userId) {
        Session currentSession=sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder=currentSession.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("userId"), userId));
        Query query = currentSession.createQuery(criteriaQuery);
        return (User) query.getSingleResult();
    }
}
