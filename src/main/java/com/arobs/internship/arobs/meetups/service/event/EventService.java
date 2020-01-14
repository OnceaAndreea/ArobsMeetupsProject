package com.arobs.internship.arobs.meetups.service.event;

import com.arobs.internship.arobs.meetups.entity.Event;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface EventService {

    public void addEvent(EventDTO eventDTO);

    public void updateEvent(int eventId, String date, String room, int maxAttendees,String difficulty);

    public List<EventDTO> getAllEvents();

}
