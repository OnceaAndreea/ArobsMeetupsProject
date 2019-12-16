package com.arobs.internship.arobs.meetups.service.proposal;

import com.arobs.internship.arobs.meetups.entity.Proposal;

import java.util.List;

public interface ProposalService {

    public Proposal addProposal(Proposal proposal);

    public List<Proposal> getAllProposals();
}

