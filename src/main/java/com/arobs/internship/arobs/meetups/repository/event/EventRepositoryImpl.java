package com.arobs.internship.arobs.meetups.repository.event;

import com.arobs.internship.arobs.meetups.entity.Event;
import com.arobs.internship.arobs.meetups.entity.Proposal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;

@Repository
public class EventRepositoryImpl implements EventRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addEvent(Event event) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(event);
    }

    @Override
    public Event getEventById(int eventId) {

        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Event> criteriaQuery = criteriaBuilder.createQuery(Event.class);
        Root<Event> root = criteriaQuery.from(Event.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("eventId"), eventId));
        Query query = currentSession.createQuery(criteriaQuery);
        return (Event) query.getSingleResult();
    }


}
