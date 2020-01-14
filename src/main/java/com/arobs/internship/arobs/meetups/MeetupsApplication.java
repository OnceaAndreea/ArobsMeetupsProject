package com.arobs.internship.arobs.meetups;

import com.arobs.internship.arobs.meetups.configuration.HibernateUtil;
import com.arobs.internship.arobs.meetups.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@EnableScheduling
public class MeetupsApplication {
    public static void main(String[] args) {

        SpringApplication.run(MeetupsApplication.class,args);


    }

}
