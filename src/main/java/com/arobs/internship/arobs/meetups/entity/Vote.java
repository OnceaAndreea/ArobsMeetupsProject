package com.arobs.internship.arobs.meetups.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="votes")
public class Vote {

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
