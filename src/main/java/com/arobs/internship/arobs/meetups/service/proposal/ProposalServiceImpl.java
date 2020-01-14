package com.arobs.internship.arobs.meetups.service.proposal;

import com.arobs.internship.arobs.meetups.entity.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProposalServiceImpl implements ProposalService {

    @Autowired
    ProposalObject proposalObject;

    @Override
    @Transactional
    public void addProposal(ProposalDTO proposalDTO) {
        proposalObject.addProposal(proposalDTO);
    }

    @Override
    @Transactional
    public List<ProposalDTO> getAllProposalsOfUser(int userId) {
        return proposalObject.getAllProposalsOfUser(userId);
    }

    @Override
    @Transactional
    public ProposalDTO getProposalById(int proposalId) {
        return proposalObject.getProposalById(proposalId);
    }

    @Transactional
    @Override
    public void deleteAllProposals(int userId) {
        proposalObject.deleteAllProposals(userId);
    }

    @Transactional
    @Override
    public void deleteProposalById(int proposalId) {
        proposalObject.deleteProposalById(proposalId);
    }

    @Override
    @Transactional
    public void updateProposal(int proposalId,String title,String description,String language,int duration,String difficulty,int maxAttendees) {
        proposalObject.updateProposal(proposalId,title,description,language,duration,difficulty,maxAttendees);
    }

    @Override
    @Transactional
    public List<ProposalDTO> getAllProposals() {
       return proposalObject.getAllProposals();


    }

    @Override
    @Transactional
    public List<ProposalDTO> getTopFiveMostVotedProposals() {
     return proposalObject.getTopFiveMostVotedProposals();
    }
}


