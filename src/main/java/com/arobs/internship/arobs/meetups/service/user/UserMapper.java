package com.arobs.internship.arobs.meetups.service.user;

import com.arobs.internship.arobs.meetups.entity.User;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.generator.specification.Convert;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserMapper extends ConfigurableMapper implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private MapperFactory mapperFactory;

    public UserMapper() {
        super(false);
    }


    protected void configure(MapperFactory factory) {
        this.mapperFactory = factory;

        mapperFactory.classMap(User.class, UserDTO.class).byDefault().register();

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        init();
    }
}


