package com.arobs.internship.arobs.meetups.service.event;

import org.springframework.stereotype.Service;

@Service
public interface EventService {

    public void addEvent(EventDTO eventDTO);

}
