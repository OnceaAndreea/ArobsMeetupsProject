package com.arobs.internship.arobs.meetups.service.event;

import com.arobs.internship.arobs.meetups.entity.Event;
import com.arobs.internship.arobs.meetups.entity.Proposal;
import com.arobs.internship.arobs.meetups.entity.Vote;
import com.arobs.internship.arobs.meetups.repository.event.EventRepository;
import com.arobs.internship.arobs.meetups.repository.proposal.ProposalRepository;
import com.arobs.internship.arobs.meetups.repository.proposal.ProposalRepositoryConstants;
import com.arobs.internship.arobs.meetups.repository.proposal.ProposalRepositoryFactory;
import com.arobs.internship.arobs.meetups.repository.vote.VoteRepository;
import com.arobs.internship.arobs.meetups.service.vote.VoteDTO;
import com.arobs.internship.arobs.meetups.service.vote.VoteMapper;
import com.arobs.internship.arobs.meetups.service.vote.VoteObject;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class EventObject {

    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(VoteObject.class);

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ProposalRepositoryFactory proposalRepositoryFactory;

    @Autowired
    EventMapper eventMapper;

    public void addEvent(EventDTO eventDTO) {

        if (eventDTO != null) {

            ProposalRepository proposalRepository = proposalRepositoryFactory.createProposalRepository(ProposalRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
            Proposal proposal = proposalRepository.getProposalById(eventDTO.getProposalId());

            Event event = eventMapper.map(eventDTO, Event.class);
            eventRepository.addEvent(event);
            proposalRepository.deleteProposal(proposal);

            logger.log(Level.INFO, "Event with id " + event.getEventId() + " was added successfully");

        }
    }

    public void updateEvent(int eventId, String date, String room, int maxAttendees) {

        Event event = eventRepository.getEventById(eventId);

        if (event != null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dt = null;
            try {
                dt = df.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            event.setEventDate(dt);
            event.setRoom(room);
            event.setMaxAttendees(maxAttendees);

        } else
            logger.log(Level.INFO, "Event with id " + event.getEventId() + " doesn't exist");
    }
}




