package com.arobs.internship.arobs.meetups.service.attendance;

import com.arobs.internship.arobs.meetups.entity.Attendance;
import com.arobs.internship.arobs.meetups.entity.Event;
import com.arobs.internship.arobs.meetups.repository.attendance.AttendanceRepository;
import com.arobs.internship.arobs.meetups.repository.event.EventRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class AttendanceObject {

    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(Attendance.class);

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    AttendanceMapper attendanceMapper;

    @Autowired
    EventRepository eventRepository;

    public void addAttendance(AttendanceDTO attendanceDTO) {

        Event event = eventRepository.getEventById(attendanceDTO.getEventId());
        if (attendanceDTO != null)
            if (event.getMaxAttendees() > event.getEventAttendees().size())
                if (attendanceDTO.getUserId() != event.getUser().getUserId()) {

                    Attendance attendance = attendanceMapper.map(attendanceDTO, Attendance.class);
                    attendanceRepository.addAttendance(attendance);
                    event.getEventAttendees().add(attendance);

                } else
                    logger.log(Level.INFO, "User can't register as attendee to his event");
            else
                logger.log(Level.INFO, "All the seats for this event are reserved");
        else
            logger.log(Level.INFO, "AttendanceDTO is null");

    }

    public void giveFeedback(int attendanceId, int note, String comment) throws ParseException {

        Attendance attendance = attendanceRepository.getAttendanceById(attendanceId);

        if (attendance != null)
            if (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(attendance.getEvent().getEventDate().toString()).before(new Date()))
                if (note >= 1 && note <= 5) {
                    attendance.setNote(note);
                    attendance.setComment(comment);
                    attendance.getUser().addPoints(2);
                } else
                    logger.log(Level.INFO, "Note should be beetween 1 and 5!");
            else
                logger.log(Level.INFO, "Can't give feedback! This event has not happened yet!");
        else
            logger.log(Level.INFO, "Attendance with id " + attendance.getAttendanceId() + " doesn't exist");
    }
}
