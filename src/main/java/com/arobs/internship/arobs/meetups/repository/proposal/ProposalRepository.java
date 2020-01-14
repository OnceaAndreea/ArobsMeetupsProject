package com.arobs.internship.arobs.meetups.repository.proposal;

import com.arobs.internship.arobs.meetups.configuration.DataBaseConnection;
import com.arobs.internship.arobs.meetups.entity.Proposal;
import com.arobs.internship.arobs.meetups.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public interface ProposalRepository {

    void addProposal(Proposal proposal);

    List<Proposal> getAllProposalsOfUser(int userId);

    Proposal getProposalById(int proposalId);

    void deleteProposal(Proposal proposal);

    List<Proposal> getAllProposals();
}

