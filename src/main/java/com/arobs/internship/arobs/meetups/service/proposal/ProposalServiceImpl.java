package com.arobs.internship.arobs.meetups.service.proposal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalServiceImpl implements ProposalService {

    @Autowired
    ProposalObject proposalObject;


    @Override
    public void addProposal(ProposalDTO proposalDTO) {
        proposalObject.addProposal(proposalDTO);
    }

    @Override
    public List<ProposalDTO> getAllProposals(int userId) {
       return proposalObject.getAllProposals(userId);
    }
}
