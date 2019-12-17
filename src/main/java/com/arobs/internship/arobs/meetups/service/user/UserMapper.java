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
        addAllMapperBeans(applicationContext);

        mapperFactory.classMap(User.class, UserDTO.class).byDefault().register();

    }

    private void addAllMapperBeans(final ApplicationContext applicationContext) {

        //get all existing mappers from context
        Mapper<String, Mapper> mappers = (Mapper<String, Mapper>) applicationContext.getBeansOfType(Mapper.class);
        mapperFactory.registerMapper(mappers);

        //get all converters from context
        Map<String, Convert> beansOfType = applicationContext.getBeansOfType(Convert.class);
         //mapperFactory.getConverterFactory().registerConverter();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        init();
    }
}

