package com.arobs.internship.arobs.meetups.service.attendance;

import com.arobs.internship.arobs.meetups.entity.Attendance;
import com.arobs.internship.arobs.meetups.entity.Event;
import com.arobs.internship.arobs.meetups.entity.User;
import com.arobs.internship.arobs.meetups.repository.event.EventRepository;
import com.arobs.internship.arobs.meetups.repository.user.UserRepository;
import com.arobs.internship.arobs.meetups.repository.user.UserRepositoryConstants;
import com.arobs.internship.arobs.meetups.repository.user.UserRepositoryFactory;
import com.arobs.internship.arobs.meetups.service.event.EventMapper;
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

@Component
public class AttendanceMapper extends ConfigurableMapper implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private MapperFactory mapperFactory;
    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(EventMapper.class);

    @Autowired
    UserRepositoryFactory userRepositoryFactory;

    @Autowired
    EventRepository eventRepository;

    public AttendanceMapper() {
        super(false);
    }


    protected void configure(MapperFactory factory) {
        this.mapperFactory = factory;

        mapperFactory.classMap(Attendance.class, AttendanceDTO.class)
                .customize(new CustomMapper<Attendance, AttendanceDTO>() {

                    @Override
                    public void mapAtoB(Attendance attendance, AttendanceDTO attendanceDTO, MappingContext context) {
                        attendanceDTO.setUserId(attendance.getUser().getUserId());
                        attendanceDTO.setEventId(attendance.getEvent().getEventId());
                    }

                    @Override
                    public void mapBtoA(AttendanceDTO attendanceDTO, Attendance attendance, MappingContext context) {
                        UserRepository userRepository = userRepositoryFactory.createUserRepository(UserRepositoryConstants.HIBERNATE_REPOSITORY_TYPE);
                        User user = userRepository.getUserById(attendanceDTO.getUserId());
                        Event event = eventRepository.getEventById(attendanceDTO.getEventId());

                        if (user != null)
                            attendance.setUser(user);
                        else
                            logger.log(Level.INFO, "User with id " + user.getUserId() + "doesn't exist");

                        if (event != null)
                            attendance.setEvent(event);
                        else
                            logger.log(Level.INFO, "Event with id " + event.getEventId() + "doesn't exist");
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
