package com.arobs.internship.arobs.meetups.repository.event;

import com.arobs.internship.arobs.meetups.entity.Event;

import java.util.Date;
import java.util.List;

public interface EventRepository {

    void addEvent(Event event);

    public Event getEventById(int eventId);

    public List<Event> getAllEvents();

}
