package com.arobs.internship.arobs.meetups.service.vote;

import com.arobs.internship.arobs.meetups.entity.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class VoteServiceImpl implements VoteService{

    @Autowired
    VoteObject voteObject;

    @Override
    @Transactional
    public void addVote(VoteDTO voteDTO) {
        voteObject.addVote(voteDTO);
    }

    @Override
    @Transactional
    public List<VoteDTO> getAllVotes() {
        return voteObject.getAllVotes();
    }


}
