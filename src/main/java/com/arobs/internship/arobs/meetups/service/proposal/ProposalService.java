package com.arobs.internship.arobs.meetups.service.proposal;

import com.arobs.internship.arobs.meetups.entity.Proposal;

import java.util.List;

public interface ProposalService {

    public void addProposal(ProposalDTO proposalDTO);

    public List<ProposalDTO> getAllProposals(int userId);
}

