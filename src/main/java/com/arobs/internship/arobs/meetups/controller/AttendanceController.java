package com.arobs.internship.arobs.meetups.controller;


import com.arobs.internship.arobs.meetups.service.attendance.AttendanceDTO;
import com.arobs.internship.arobs.meetups.service.attendance.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @PostMapping("/create")
    public void addAttendance(@RequestBody AttendanceDTO attendanceDTO){
        attendanceService.addAttendance(attendanceDTO);
    }

    @PutMapping("/attendanceId/{attendanceId}/note/{note}/comment/{comment}")
    public void giveFeedback(@PathVariable int attendanceId,@PathVariable int note,@PathVariable String comment) throws ParseException {
        attendanceService.giveFeedback(attendanceId,note,comment);
    }
}
