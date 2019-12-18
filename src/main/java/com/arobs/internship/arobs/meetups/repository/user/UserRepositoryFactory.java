package com.arobs.internship.arobs.meetups.repository.user;

public class UserRepositoryFactory {

    public UserRepository createUserRepository(String type){
        if(type.equals("JDBC")){
            return new UserRepositoryJDBCImpl();
        }else if(type.equals("HIBERNATE")){
            return new UserRepositoryHibernateImpl();
        }
        return null;
    }
}
