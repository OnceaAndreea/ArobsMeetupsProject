package com.arobs.internship.arobs.meetups.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name = "eventId", nullable = false)
    private int eventId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "difficulty", nullable = false)
    private String difficulty;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = " maxAttendees", nullable = false)
    private int maxAttendees;

    @Column(name = "room", nullable = false)
    private String room;

    @Column(name = "eventDate", nullable = false)
    private String eventDate;

    @Column(name = "isClosed", nullable = false)
    private boolean isClosed;


    //one event can have many attendees
    @OneToMany(
            mappedBy = "event",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Attendance> eventAttendees = new ArrayList<>();

    public Event(int eventId) {
        this.eventId = eventId;
    }

    public Event() {
    }


    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMaxAttendees() {
        return maxAttendees;
    }

    public void setMaxAttendees(int maxAttendees) {
        this.maxAttendees = maxAttendees;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public List<Attendance> getEventAttendees() {
        return eventAttendees;
    }

    public void setEventAttendees(List<Attendance> eventAttendees) {
        this.eventAttendees = eventAttendees;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    @Override
    public String toString() {
        return "Event with eventId:" + this.getEventId() + ",userId:" + this.getUser().getUserId() + ",title:" + this.getTitle() +
                ",description:" + this.getDescription() + ",type:" + this.getType() + ",difficulty:" + this.getDifficulty() + ",language:"
                + this.getLanguage() + ",duration:" + this.getDuration() + ",maxAttendees:" + this.getMaxAttendees() + ",room:" + this.getRoom() + ",eventDate:" + this.getEventDate();
    }

    public void awardEventOrganizer() {
        if (this.getDifficulty() == "Easy")
            this.getUser().addPoints(20);
        else if (this.getDifficulty() == "Medium")
            this.getUser().addPoints(35);
        else if (this.getDifficulty() == "High")
            this.getUser().addPoints(50);
    }

    public void awardEventAttendees() {
        List<Attendance> eventAttendees = this.getEventAttendees();
        for (int i = 0; i < eventAttendees.size(); i++) {
            eventAttendees.get(i).getUser().addPoints(5);
        }
    }


}
