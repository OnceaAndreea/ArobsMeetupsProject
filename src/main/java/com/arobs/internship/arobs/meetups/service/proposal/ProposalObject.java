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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProposalObject {

    @Autowired
    ProposalRepositoryFactory proposalRepositoryFactory;

    @Autowired
    ProposalMapper proposalMapper;

    public void addProposal(ProposalDTO proposalDTO) {
        ProposalRepository proposalRepository = proposalRepositoryFactory.createProposalRepository(ProposalRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
        if (proposalDTO != null) {
            Proposal proposal = proposalMapper.map(proposalDTO, Proposal.class);
            proposalRepository.addProposal(proposal);
        }
    }

    public List<ProposalDTO> getAllProposalsOfUser(int userId) {
        ProposalRepository proposalRepository = proposalRepositoryFactory.createProposalRepository(ProposalRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
        List<Proposal> proposals = proposalRepository.getAllProposalsOfUser(userId);
        if (proposals != null)
            return proposalMapper.mapAsList(proposals, ProposalDTO.class);
        return null;
    }

    public ProposalDTO getProposalById(int proposalId) {
        ProposalRepository proposalRepository = proposalRepositoryFactory.createProposalRepository(ProposalRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
        Proposal proposal = proposalRepository.getProposalById(proposalId);
        if (proposal != null)
            return proposalMapper.map(proposal, ProposalDTO.class);
        return null;
    }

    public void deleteAllProposals(int userId) {
        ProposalRepository proposalRepository = proposalRepositoryFactory.createProposalRepository(ProposalRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
        List<Proposal> proposals = proposalRepository.getAllProposalsOfUser(userId);
        if (proposals != null) {
            for (int i = 0; i < proposals.size(); i++)
                proposalRepository.deleteProposal(proposals.get(i));
        }
    }

    public void deleteProposalById(int proposalId) {
        ProposalRepository proposalRepository = proposalRepositoryFactory.createProposalRepository(ProposalRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
        Proposal proposal = proposalRepository.getProposalById(proposalId);
        if (proposal != null) {
            proposalRepository.deleteProposal(proposal);
        }
    }

    public void updateProposal(int proposalId,String title,String description,String language,int duration,String difficulty,int maxAttendees) {
        ProposalRepository proposalRepository = proposalRepositoryFactory.createProposalRepository(ProposalRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
        Proposal proposal = proposalRepository.getProposalById(proposalId);
        if (proposal != null) {
            proposal.setTitle(title);
            proposal.setDescription(description);
            proposal.setLanguage(language);
            proposal.setDuration(duration);
            proposal.setDifficulty(difficulty);
            proposal.setMaxAttendees(maxAttendees);
            proposalRepository.addProposal(proposal);
        }
    }

    public List<ProposalDTO> getAllProposals() {

        ProposalRepository proposalRepository = proposalRepositoryFactory.createProposalRepository(ProposalRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
        List<Proposal> proposals = proposalRepository.getAllProposals();

        if (proposals != null)
            return proposalMapper.mapAsList(proposals, ProposalDTO.class);
        return null;
    }

    public List<ProposalDTO> getTopFiveMostVotedProposals() {

        ProposalRepository proposalRepository = proposalRepositoryFactory.createProposalRepository(ProposalRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
        List<Proposal> proposals = proposalRepository.getAllProposals();

        if (proposals != null)
            Collections.sort(proposals);

        List<Proposal> topFiveProposals = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            topFiveProposals.add(proposals.get(i));

        return proposalMapper.mapAsList(topFiveProposals, ProposalDTO.class);
    }
}
