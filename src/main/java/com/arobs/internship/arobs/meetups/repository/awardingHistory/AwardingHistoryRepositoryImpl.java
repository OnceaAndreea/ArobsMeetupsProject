package com.arobs.internship.arobs.meetups.repository.awardingHistory;

import com.arobs.internship.arobs.meetups.entity.AwardingHistory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AwardingHistoryRepositoryImpl implements AwardingHistoryRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addAwardingHistory(AwardingHistory awardingHistory) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(awardingHistory);
    }
}
