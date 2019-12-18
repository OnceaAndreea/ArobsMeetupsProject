package com.arobs.internship.arobs.meetups.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name="eventId")
    private int  eventId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="type")
    private String type;

    @Column(name="difficulty")
    private String difficulty;

    @Column(name="language")
    private String language;

    @Column(name="duration")
    private int duration;

    @Column(name=" maxAttendees")
    private int maxAttendees;

    @Column(name="room")
    private String room;

    @Column(name="eventDate")
    private Date eventDate;

    //one event can have many attendees
    @OneToMany(
            mappedBy = "events",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Attendance> eventAttendees = new ArrayList<>();



}
