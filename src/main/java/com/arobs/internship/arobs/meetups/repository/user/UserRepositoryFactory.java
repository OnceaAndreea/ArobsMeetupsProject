package com.arobs.internship.arobs.meetups.repository.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryFactory {

    @Autowired
    UserRepositoryHibernateImpl userRepositoryHibernate;

    @Autowired
    UserRepositoryJDBCImpl userRepositoryJDBC;

    public UserRepository createUserRepository(String type){
        if(type.equals(UserRepositoryConstants.JDBC_REPOSITORY_TYPE)){
            return new UserRepositoryJDBCImpl();
        }else if(type.equals(UserRepositoryConstants.HIBERNATE_REPOSITORY_TYPE)){
            return new UserRepositoryHibernateImpl();
        }
        return null;
    }
}
