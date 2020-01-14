package com.arobs.internship.arobs.meetups.repository.vote;

import com.arobs.internship.arobs.meetups.entity.Vote;

import java.util.List;

public interface VoteRepository {

    public void addVote(Vote vote);

    public List<Vote> getAllVotes();

}
