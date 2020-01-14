package com.arobs.internship.arobs.meetups.controller;

import com.arobs.internship.arobs.meetups.entity.Event;
import com.arobs.internship.arobs.meetups.service.event.EventDTO;
import com.arobs.internship.arobs.meetups.service.event.EventService;
import com.arobs.internship.arobs.meetups.service.proposal.ProposalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("/create")
    public void create(@RequestBody EventDTO eventDTO) {
        eventService.addEvent(eventDTO);
    }

    @PutMapping("/eventId/{eventId}/date/{date}/room/{room}/maxAttendees/{maxAttendees}")
    public void updateEvent(int eventId, String date, String room, int maxAttendees,String difficulty){
        eventService.updateEvent(eventId,date,room,maxAttendees,difficulty);
    }

    @GetMapping("/getAllEvents")
    public List<EventDTO> getAllEvents(){
        return eventService.getAllEvents();
    }
}