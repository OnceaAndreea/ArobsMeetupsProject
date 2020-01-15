package com.arobs.internship.arobs.meetups.repository.prize;

import com.arobs.internship.arobs.meetups.entity.Prize;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class PrizeRepositoryImpl implements PrizeRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addPrize(Prize prize) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(prize);
    }

    @Override
    public Prize getPrizeById(int prizeId) {

        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Prize> criteriaQuery = criteriaBuilder.createQuery(Prize.class);
        Root<Prize> root = criteriaQuery.from(Prize.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("prizeId"), prizeId));
        Query query = currentSession.createQuery(criteriaQuery);
        return (Prize) query.getSingleResult();
    }
}
