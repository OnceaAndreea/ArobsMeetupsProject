package com.arobs.internship.arobs.meetups.service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EventServiceImpl implements EventService{

    @Autowired
    EventObject eventObject;

    @Override
    @Transactional
    public void addEvent(EventDTO eventDTO) {
        eventObject.addEvent(eventDTO);
    }
}
