package com.arobs.internship.arobs.meetups;

import com.arobs.internship.arobs.meetups.configuration.HibernateUtil;
import com.arobs.internship.arobs.meetups.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


public class MeetupsApplication {
    public static void main(String[] args) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<User> users = session.createQuery("from User", User.class).list();
            for (User user : users) {
                System.out.println(user.getFirstName()+" "+user.getLastName());

            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        StringBuilder a=new StringBuilder();
        a.append("ana");
        a.append(4);
        System.out.println(a.toString());

    }

}