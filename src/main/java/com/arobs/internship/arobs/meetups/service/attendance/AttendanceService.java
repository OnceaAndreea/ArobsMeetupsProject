package com.arobs.internship.arobs.meetups.service.attendance;

import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface AttendanceService {

    public void addAttendance(AttendanceDTO attendanceDTO);

    public void giveFeedback(int attendanceId,int note,String comment) throws ParseException;


}
