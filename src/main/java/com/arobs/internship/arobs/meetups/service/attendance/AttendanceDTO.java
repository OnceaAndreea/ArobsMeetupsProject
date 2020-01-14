package com.arobs.internship.arobs.meetups.service.attendance;

public class AttendanceDTO {

    private int userId;
    private int eventId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

}
