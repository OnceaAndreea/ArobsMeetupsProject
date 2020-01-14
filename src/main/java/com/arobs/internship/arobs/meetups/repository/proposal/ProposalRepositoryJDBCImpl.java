package com.arobs.internship.arobs.meetups.repository.proposal;

import com.arobs.internship.arobs.meetups.configuration.DataBaseConnection;
import com.arobs.internship.arobs.meetups.entity.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ProposalRepositoryJDBCImpl implements ProposalRepository {

    @Autowired
    DataBaseConnection dataBaseConnection;

    @Override
    public void addProposal(Proposal proposal) {
        String sql = " Insert into proposals(userId,title,description,type,difficulty,language,duration,maxAttendees,votes)"
                + " values (?, ?, ?, ?, ?)";

        try (Connection con = dataBaseConnection.getDs().getConnection()) {

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, proposal.getUser().getUserId());
            pst.setString(2, proposal.getTitle());
            pst.setString(3, proposal.getDescription());
            pst.setString(4, proposal.getType());
            pst.setString(5, proposal.getDifficulty());
            pst.setString(6, proposal.getLanguage());
            pst.setInt(7, proposal.getDuration());
            pst.setInt(8, proposal.getMaxAttendees());

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Proposal> getAllProposalsOfUser(int userId) {

        List<Proposal> proposals = new ArrayList<>();

        String sql = "select * from proposals" +
                " where userId='" + userId + "' ";

        try (Connection con = dataBaseConnection.getDs().getConnection()) {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                int proposalId = rs.getInt("proposalId");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String type = rs.getString("type");
                String difficulty = rs.getString("difficulty");
                String language = rs.getString("language");
                int duration = rs.getInt("duration");
                int maxAttendees = rs.getInt("maxAttendees");
                int votes = rs.getInt("votes");

                Proposal proposal = new Proposal(proposalId, title, description, type, difficulty, language, duration, maxAttendees);

                proposals.add(proposal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proposals;
    }

    @Override
    public Proposal getProposalById(int proposalId) {
        return null;
    }

    @Override
    public void deleteProposal(Proposal proposal) {

    }

    @Override
    public List<Proposal> getAllProposals() {
        return null;
    }


}
