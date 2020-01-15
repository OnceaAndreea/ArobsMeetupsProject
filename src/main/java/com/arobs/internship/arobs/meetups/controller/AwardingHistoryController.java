package com.arobs.internship.arobs.meetups.controller;

import com.arobs.internship.arobs.meetups.service.awardingHistory.AwardingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/awardingHistory")
public class AwardingHistoryController {

  @Autowired
    AwardingHistoryService awardingHistoryService;

  @PostMapping("/create")
    public void awardUserFromTopOfeLeaderboard(@RequestParam int prizeId){
      awardingHistoryService.awardUserFromTopOfLeaderboard(prizeId);
  }
}
