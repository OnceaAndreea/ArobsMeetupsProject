package com.arobs.internship.arobs.meetups.service.proposal;

import com.arobs.internship.arobs.meetups.entity.Proposal;
import com.arobs.internship.arobs.meetups.entity.User;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.generator.specification.Convert;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProposalMapper extends ConfigurableMapper implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private MapperFactory mapperFactory;

    public ProposalMapper() {
        super(false);
    }


    protected void configure(MapperFactory factory) {
        this.mapperFactory = factory;

        mapperFactory.classMap(Proposal.class, ProposalDTO.class)
                .customize(new CustomMapper<Proposal, ProposalDTO>() {
                    @Override
                    public void mapAtoB(Proposal proposal, ProposalDTO proposalDTO, MappingContext context) {
                        proposalDTO.setUserId(proposal.getUser().getUserId());
                    }

                    @Override
                    public void mapBtoA(ProposalDTO proposalDTO, Proposal proposal, MappingContext context) {
                        User user = new User(proposalDTO.getUserId());
                        proposal.setUser(user);
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
