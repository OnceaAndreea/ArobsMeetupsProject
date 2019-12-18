package com.arobs.internship.arobs.meetups.service.proposal;

import com.arobs.internship.arobs.meetups.entity.Proposal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProposalService {

    public void addProposal(ProposalDTO proposalDTO);

    public List<ProposalDTO> getAllProposals(int userId);
}

