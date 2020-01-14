package com.arobs.internship.arobs.meetups.controller;

import com.arobs.internship.arobs.meetups.service.event.EventDTO;
import com.arobs.internship.arobs.meetups.service.event.EventService;
import com.arobs.internship.arobs.meetups.service.proposal.ProposalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("/create")
    public void create(@RequestBody EventDTO eventDTO) {
        eventService.addEvent(eventDTO);
    }
}