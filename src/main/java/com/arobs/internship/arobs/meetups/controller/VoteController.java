package com.arobs.internship.arobs.meetups.controller;

import com.arobs.internship.arobs.meetups.service.user.UserDTO;
import com.arobs.internship.arobs.meetups.service.vote.VoteDTO;
import com.arobs.internship.arobs.meetups.service.vote.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    VoteService voteService;

    @PostMapping("/create")
    public void create(@RequestBody VoteDTO voteDTO) {
        voteService.addVote(voteDTO);
    }

    @GetMapping("/getAllVotes")
    public List<VoteDTO> getAllVotes() {
        return voteService.getAllVotes();
    }
}
