package com.arobs.internship.arobs.meetups.service.proposal;

import com.arobs.internship.arobs.meetups.entity.Proposal;
import com.arobs.internship.arobs.meetups.repository.proposal.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProposalObject {

    @Autowired
    ProposalRepository proposalRepository;
    @Autowired
    ProposalMapper proposalMapper;

    public void addProposal(ProposalDTO proposalDTO){
        Proposal proposal=proposalMapper.map(proposalDTO,Proposal.class);
        proposalRepository.addProposal(proposal);
    }

    public List<ProposalDTO> getAllProposals(int userId){
        List<Proposal>proposals= proposalRepository.getAllProposals(userId);
        if(proposals!=null)
            return proposalMapper.mapAsList(proposals,ProposalDTO.class);
        return null;
    }


}
