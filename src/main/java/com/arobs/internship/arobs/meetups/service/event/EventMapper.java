package com.arobs.internship.arobs.meetups.service.event;

import com.arobs.internship.arobs.meetups.entity.Event;
import com.arobs.internship.arobs.meetups.entity.Proposal;
import com.arobs.internship.arobs.meetups.entity.User;
import com.arobs.internship.arobs.meetups.repository.proposal.ProposalRepository;
import com.arobs.internship.arobs.meetups.repository.proposal.ProposalRepositoryConstants;
import com.arobs.internship.arobs.meetups.repository.proposal.ProposalRepositoryFactory;
import com.arobs.internship.arobs.meetups.service.proposal.ProposalDTO;
import com.arobs.internship.arobs.meetups.service.vote.VoteObject;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class EventMapper extends ConfigurableMapper implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private MapperFactory mapperFactory;
    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(EventMapper.class);

    @Autowired
    ProposalRepositoryFactory proposalRepositoryFactory;

    public EventMapper() {
        super(false);
    }

    protected void configure(MapperFactory factory) {
        this.mapperFactory = factory;

        mapperFactory.classMap(Event.class, EventDTO.class)
                .customize(new CustomMapper<Event, EventDTO>() {
                    @Override
                    public void mapAtoB(Event event, EventDTO eventDTO, MappingContext context) {
                        eventDTO.setProposalId(event.getUser().getUserId());
                    }

                    @Override
                    public void mapBtoA(EventDTO eventDTO, Event event, MappingContext context) {

                        ProposalRepository proposalRepository = proposalRepositoryFactory.createProposalRepository(ProposalRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
                        Proposal proposal = proposalRepository.getProposalById(eventDTO.getProposalId());

                        if (proposal != null) {

                            event.setUser(proposal.getUser());
                            event.setTitle(proposal.getTitle());
                            event.setDescription(proposal.getDescription());
                            event.setType(proposal.getType());
                            event.setDifficulty(proposal.getDifficulty());
                            event.setLanguage(proposal.getLanguage());
                            event.setDuration(proposal.getDuration());
                            event.setMaxAttendees(proposal.getMaxAttendees());

                        } else
                            logger.log(Level.INFO, "Proposal with id " + proposal.getProposalId() + "doesn't exist");
                    }
                })
                .byDefault().register();

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        init();
    }
}
