package com.arobs.internship.arobs.meetups.service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
public class EventServiceImpl implements EventService{

    @Autowired
    EventObject eventObject;

    @Override
    @Transactional
    public void addEvent(EventDTO eventDTO) {
        eventObject.addEvent(eventDTO);
    }

    @Override
    @Transactional
    public void updateEvent(int eventId, String date, String room, int maxAttendees) {
        eventObject.updateEvent(eventId,date,room,maxAttendees);
    }
}
