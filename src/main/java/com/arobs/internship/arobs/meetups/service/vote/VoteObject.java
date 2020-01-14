package com.arobs.internship.arobs.meetups.service.vote;

import com.arobs.internship.arobs.meetups.entity.Proposal;
import com.arobs.internship.arobs.meetups.entity.User;
import com.arobs.internship.arobs.meetups.entity.Vote;
import com.arobs.internship.arobs.meetups.repository.proposal.ProposalRepository;
import com.arobs.internship.arobs.meetups.repository.proposal.ProposalRepositoryConstants;
import com.arobs.internship.arobs.meetups.repository.proposal.ProposalRepositoryFactory;
import com.arobs.internship.arobs.meetups.repository.user.UserRepository;
import com.arobs.internship.arobs.meetups.repository.user.UserRepositoryConstants;
import com.arobs.internship.arobs.meetups.repository.user.UserRepositoryFactory;
import com.arobs.internship.arobs.meetups.repository.vote.VoteRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VoteObject {

    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(VoteObject.class);

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    UserRepositoryFactory userRepositoryFactory;

    @Autowired
    ProposalRepositoryFactory proposalRepositoryFactory;

    @Autowired
    VoteMapper voteMapper;

    public void addVote(VoteDTO voteDTO) {
        if (voteDTO != null) {

            ProposalRepository proposalRepository = proposalRepositoryFactory.createProposalRepository(ProposalRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
            UserRepository userRepository = userRepositoryFactory.createUserRepository(UserRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);

            Proposal proposal = proposalRepository.getProposalById(voteDTO.getProposalId());
            User user = userRepository.getUserById(voteDTO.getUserId());

            if (proposal != null && user != null) {
                if (user.getUserId() != proposal.getUser().getUserId()) {

                    Vote vote = voteMapper.map(voteDTO, Vote.class);
                    voteRepository.addVote(vote);
                    proposal.addVote(vote);
                    user.addPoints(1);
                    logger.log(Level.INFO, "Vote was added successfully");

                } else logger.log(Level.INFO, "User can't vote his proposals!");
            } else
                logger.log(Level.INFO, "User with given userId doesn't exist or Proposal with given proposalId doesn't doesn't exist");
        }
    }

    public List<VoteDTO> getAllVotes() {

        List<Vote> votes = voteRepository.getAllVotes();
        if (votes != null)
            return voteMapper.mapAsList(votes, VoteDTO.class);
            return null;
    }
}
