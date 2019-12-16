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
    ProposalService proposalService;

    @PostMapping
    public void create(@RequestBody ProposalDTO proposalDTO){
        proposalService.addProposal(proposalDTO);
    }

    @GetMapping("/Show_all_positions")
    public List<ProposalDTO> getAllPositions(@PathVariable int userId){
       return proposalService.getAllProposals(userId);
    }
}
