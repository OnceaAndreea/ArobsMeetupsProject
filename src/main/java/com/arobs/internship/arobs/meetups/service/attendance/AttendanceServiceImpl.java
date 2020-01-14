package com.arobs.internship.arobs.meetups.service.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

@Component
public class AttendanceServiceImpl implements AttendanceService{

    @Autowired
    AttendanceObject attendanceObject;

    @Override
    @Transactional
    public void addAttendance(AttendanceDTO attendanceDTO) {
        attendanceObject.addAttendance(attendanceDTO);
    }

    @Override
    @Transactional
    public void giveFeedback(int attendanceId, int note, String comment) throws ParseException {
        attendanceObject.giveFeedback(attendanceId,note,comment);
    }
}
