package com.arobs.internship.arobs.meetups.service.proposal;

import com.arobs.internship.arobs.meetups.entity.Proposal;
import com.arobs.internship.arobs.meetups.repository.ProposalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProposalObject {

    @Autowired
    ProposalRepo proposalRepo;
    @Autowired
    ProposalMapper proposalMapper;

    public void addProposal(ProposalDTO proposalDTO){
        Proposal proposal=proposalMapper.map(proposalDTO,Proposal.class);
        proposalRepo.addProposal(proposal);
    }

    public List<ProposalDTO> getAllProposals(int userId){
        List<Proposal>proposals=proposalRepo.getAllProposals(userId);
        if(proposals!=null)
            return proposalMapper.mapAsList(proposals,ProposalDTO.class);
        return null;
    }


}
