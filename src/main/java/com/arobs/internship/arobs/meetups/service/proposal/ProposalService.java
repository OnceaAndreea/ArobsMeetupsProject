package com.arobs.internship.arobs.meetups.service.proposal;

import com.arobs.internship.arobs.meetups.entity.Proposal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProposalService {

    public void addProposal(ProposalDTO proposalDTO);

    public List<ProposalDTO> getAllProposalsOfUser(int userId);

    public ProposalDTO getProposalById(int proposalId);

    public void deleteAllProposals(int userId);

    public void deleteProposalById(int proposalId);

    public void updateProposal(int proposalId,String title,String description,String language,int duration,String difficulty,int maxAttendees);

    public List<ProposalDTO> getAllProposals();

    public List<ProposalDTO> getTopFiveMostVotedProposals();
}

