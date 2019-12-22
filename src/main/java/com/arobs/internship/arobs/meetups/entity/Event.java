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
    @Column(name="eventId",nullable = false)
    private int  eventId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId",nullable = false)
    private User user;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="description",nullable = false)
    private String description;

    @Column(name="type",nullable = false)
    private String type;

    @Column(name="difficulty",nullable = false)
    private String difficulty;

    @Column(name="language",nullable = false)
    private String language;

    @Column(name="duration",nullable = false)
    private int duration;

    @Column(name=" maxAttendees",nullable = false)
    private int maxAttendees;

    @Column(name="room",nullable = false)
    private String room;

    @Column(name="eventDate",nullable = false)
    private Date eventDate;

    //one event can have many attendees
    @OneToMany(
            mappedBy = "event",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Attendance> eventAttendees = new ArrayList<>();



}
