package com.arobs.internship.arobs.meetups.controller;

import com.arobs.internship.arobs.meetups.service.proposal.ProposalDTO;
import com.arobs.internship.arobs.meetups.service.proposal.ProposalService;
import com.arobs.internship.arobs.meetups.service.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proposal")
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @PostMapping
    public void create(@RequestBody ProposalDTO proposalDTO) {
        proposalService.addProposal(proposalDTO);
    }

    @GetMapping(value = "/id/{userId}")
    public List<ProposalDTO> getAllProposalsOfUser(@PathVariable int userId) {
        return proposalService.getAllProposalsOfUser(userId);
    }

    @GetMapping(value = "/proposalId/{proposalId}")
    public ProposalDTO getProposalById(@PathVariable int proposalId) {
        return proposalService.getProposalById(proposalId);
    }

    @GetMapping("/getAllProposals")
    public List<ProposalDTO> getAllProposals() {
        return proposalService.getAllProposals();
    }

    @GetMapping("/getTopFiveMostVotedProposals")
    public List<ProposalDTO> getTopFiveMostVotedProposals() {
        return proposalService.getTopFiveMostVotedProposals();
    }

    @DeleteMapping("/proposalId/{proposalId}")
    public void deleteProposalById(@PathVariable int proposalId) {
        proposalService.deleteProposalById(proposalId);
    }

    @DeleteMapping("/userId/{userId}")
    public void deleteAllProposalsOfUser(@PathVariable int userId) {
        proposalService.deleteAllProposals(userId);
    }

    @PutMapping("/proposalId{proposalId}/title{title}/description{description}/language{language}/duration{duration}/difficulty{difficulty}/maxAttendees{maxAttendees}")
    public void updateProposal(@PathVariable int proposalId,@PathVariable String title, @PathVariable String description,@PathVariable String language,@PathVariable int duration,@PathVariable String difficulty,@PathVariable int maxAttendees) {
        proposalService.updateProposal(proposalId,title,description,language,duration,difficulty,maxAttendees);
    }


}
