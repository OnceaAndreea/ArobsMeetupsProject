package com.arobs.internship.arobs.meetups.service.proposal;

import com.arobs.internship.arobs.meetups.entity.Proposal;
import com.arobs.internship.arobs.meetups.entity.User;
import com.arobs.internship.arobs.meetups.repository.proposal.ProposalRepository;
import com.arobs.internship.arobs.meetups.repository.proposal.ProposalRepositoryConstants;
import com.arobs.internship.arobs.meetups.repository.proposal.ProposalRepositoryFactory;
import com.arobs.internship.arobs.meetups.repository.user.UserRepository;
import com.arobs.internship.arobs.meetups.repository.user.UserRepositoryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProposalObject {

    @Autowired
    ProposalRepositoryFactory proposalRepositoryFactory;

    @Autowired
    ProposalMapper proposalMapper;

    public void addProposal(ProposalDTO proposalDTO){
        ProposalRepository proposalRepository = proposalRepositoryFactory.createProposalRepository(ProposalRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
        if (proposalDTO!=null){
            Proposal proposal = proposalMapper.map(proposalDTO, Proposal.class);
            proposalRepository.addProposal(proposal);
        }
    }

    public List<ProposalDTO> getAllProposals(int userId){
        ProposalRepository proposalRepository = proposalRepositoryFactory.createProposalRepository(ProposalRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
        List<Proposal>proposals= proposalRepository.getAllProposals(userId);
        if(proposals!=null)
            return proposalMapper.mapAsList(proposals,ProposalDTO.class);
        return null;
    }


}
