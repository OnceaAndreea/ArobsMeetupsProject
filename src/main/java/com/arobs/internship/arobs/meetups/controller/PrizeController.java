package com.arobs.internship.arobs.meetups.controller;

import com.arobs.internship.arobs.meetups.service.prize.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class PrizeController {

    @Autowired
    PrizeService prizeService;

    @PostMapping
    public void addPrize(@RequestParam String description,@RequestParam String value){
        prizeService.addPrize(description,value);
    }
}
