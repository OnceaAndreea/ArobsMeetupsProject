package com.arobs.internship.arobs.meetups.service.vote;

import com.arobs.internship.arobs.meetups.entity.Vote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoteService {

    public void addVote(VoteDTO voteDTO);

    public List<VoteDTO> getAllVotes();
}
