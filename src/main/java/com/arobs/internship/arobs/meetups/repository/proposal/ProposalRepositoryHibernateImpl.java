package com.arobs.internship.arobs.meetups.repository.proposal;

import com.arobs.internship.arobs.meetups.entity.Proposal;
import com.arobs.internship.arobs.meetups.entity.User;
import com.arobs.internship.arobs.meetups.repository.user.UserRepository;
import com.arobs.internship.arobs.meetups.repository.user.UserRepositoryHibernateImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;

@Repository
public class ProposalRepositoryHibernateImpl implements ProposalRepository{

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    UserRepositoryHibernateImpl userRepositoryHibernate;

    @Override
    public void addProposal(Proposal proposal) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(proposal);
    }

    @Override
    public List<Proposal> getAllProposalsOfUser(int userId) {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Proposal> criteriaQuery = criteriaBuilder.createQuery(Proposal.class);
        Root<Proposal> root = criteriaQuery.from(Proposal.class);
        User user=userRepositoryHibernate.getUserById(userId);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("user"), user));
        Query query = currentSession.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public Proposal getProposalById(int proposalId) {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Proposal> criteriaQuery = criteriaBuilder.createQuery(Proposal.class);
        Root<Proposal> root = criteriaQuery.from(Proposal.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("proposalId"), proposalId));
        Query query = currentSession.createQuery(criteriaQuery);
        return (Proposal) query.getSingleResult();
    }

    @Override
    public void deleteProposal(Proposal proposal) {
        Session currentSession=sessionFactory.getCurrentSession();
        currentSession.delete(proposal);
    }

    @Override
    public List<Proposal> getAllProposals() {

        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Proposal> criteriaQuery = criteriaBuilder.createQuery(Proposal.class);
        Root<Proposal> root = criteriaQuery.from(Proposal.class);
        criteriaQuery.select(root);
        Query query = currentSession.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
