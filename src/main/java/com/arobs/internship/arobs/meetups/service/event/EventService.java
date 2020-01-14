package com.arobs.internship.arobs.meetups.service.event;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface EventService {

    public void addEvent(EventDTO eventDTO);

    public void updateEvent(int eventId, String date, String room, int maxAttendees);
}
