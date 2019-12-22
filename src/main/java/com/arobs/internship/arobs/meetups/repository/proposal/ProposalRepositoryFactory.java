package com.arobs.internship.arobs.meetups.repository.proposal;

import com.arobs.internship.arobs.meetups.entity.Proposal;
import com.arobs.internship.arobs.meetups.repository.user.UserRepository;
import com.arobs.internship.arobs.meetups.repository.user.UserRepositoryConstants;
import com.arobs.internship.arobs.meetups.repository.user.UserRepositoryHibernateImpl;
import com.arobs.internship.arobs.meetups.repository.user.UserRepositoryJDBCImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProposalRepositoryFactory {

    @Autowired
    ProposalRepositoryHibernateImpl proposalRepositoryHibernate;

    @Autowired
    ProposalRepositoryJDBCImpl proposalRepositoryJDBC;

    public ProposalRepository createProposalRepository(String type){
        if(type.equals(UserRepositoryConstants.JDBC_REPOSITORY_TYPE)){
            return proposalRepositoryJDBC;
        }else if(type.equals(UserRepositoryConstants.HIBERNATE_REPOSITORY_TYPE)){
            return proposalRepositoryHibernate;
        }
        return null;
    }
}
