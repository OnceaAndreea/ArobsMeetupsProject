package com.arobs.internship.arobs.meetups.service;

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


    private ApplicationContext  applicationContext;
    private MapperFactory mapperFactory;

    public UserMapper() {
        super(false);
    }


    protected void configure(MapperFactory factory) {
        this.mapperFactory = factory;

        addAllMapperBeans(applicationContext);
        mapperFactory.classMap();

    }

    private void addAllMapperBeans(final ApplicationContext applicationContext) {

        //get all existing mappers from context

        Map<String, Mapper> mappers = applicationContext.getBeansOfType(Mapper.class);
        mapperFactory.registerClassMap(mappers);

        //get all converters from context
        Map<String, Convert> beansOfType = applicationContext.getBeansOfType(Convert.class);
        mapperFactory.getConverterFactory().registerConverter(beansOfType);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
this.applicationContext = applicationContext;
init();
    }
}
