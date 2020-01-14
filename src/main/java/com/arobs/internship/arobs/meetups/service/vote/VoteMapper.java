package com.arobs.internship.arobs.meetups.service.vote;

import com.arobs.internship.arobs.meetups.entity.Proposal;
import com.arobs.internship.arobs.meetups.entity.User;
import com.arobs.internship.arobs.meetups.entity.Vote;
import com.arobs.internship.arobs.meetups.service.proposal.ProposalDTO;
import com.arobs.internship.arobs.meetups.service.user.UserDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class VoteMapper extends ConfigurableMapper implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private MapperFactory mapperFactory;

    public VoteMapper() {
        super(false);
    }

    protected void configure(MapperFactory factory) {
        this.mapperFactory = factory;

        mapperFactory.classMap(Vote.class, VoteDTO.class)
                .customize(new CustomMapper<Vote, VoteDTO>() {
                    @Override
                    public void mapAtoB(Vote vote, VoteDTO voteDTO, MappingContext context) {
                        voteDTO.setUserId(vote.getUser().getUserId());
                        voteDTO.setProposalId(vote.getProposal().getProposalId());
                    }

                    @Override
                    public void mapBtoA(VoteDTO voteDTO, Vote vote, MappingContext context) {
                        User user = new User(voteDTO.getUserId());
                        Proposal proposal=new Proposal(voteDTO.getProposalId());
                        vote.setUser(user);
                        vote.setProposal(proposal);
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

