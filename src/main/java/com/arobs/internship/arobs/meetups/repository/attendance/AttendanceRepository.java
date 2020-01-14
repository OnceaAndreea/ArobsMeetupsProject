package com.arobs.internship.arobs.meetups.repository.attendance;

import com.arobs.internship.arobs.meetups.entity.Attendance;

public interface AttendanceRepository {

    public void addAttendance(Attendance attendance);

    public Attendance getAttendanceById(int attendanceId);

}
