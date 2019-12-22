package com.arobs.internship.arobs.meetups.service.proposal;

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
    public List<ProposalDTO> getAllProposals(int userId) {
       return proposalObject.getAllProposals(userId);
    }
}
