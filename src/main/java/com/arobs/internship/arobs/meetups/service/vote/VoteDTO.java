package com.arobs.internship.arobs.meetups.service.vote;

public class VoteDTO {

    private int userId;
    private int proposalId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProposalId() {
        return proposalId;
    }

    public void setProposalId(int proposalId) {
        this.proposalId = proposalId;
    }
}
