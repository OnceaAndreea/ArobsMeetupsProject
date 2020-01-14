package com.arobs.internship.arobs.meetups.repository.vote;

import com.arobs.internship.arobs.meetups.entity.Proposal;
import com.arobs.internship.arobs.meetups.entity.Vote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class VoteRepositoryImpl implements VoteRepository {

    @Autowired
    SessionFactory sessionFactory;

    public void addVote(Vote vote){
      Session currentSession=sessionFactory.getCurrentSession();
      currentSession.save(vote);
    }

    @Override
    public List<Vote> getAllVotes() {

        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Vote> criteriaQuery = criteriaBuilder.createQuery(Vote.class);
        Root<Vote> root = criteriaQuery.from(Vote.class);
        criteriaQuery.select(root);
        Query query = currentSession.createQuery(criteriaQuery);
        return query.getResultList();
    }


}
