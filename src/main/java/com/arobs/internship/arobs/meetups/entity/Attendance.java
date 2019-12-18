package com.arobs.internship.arobs.meetups.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name="events")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name="attendanceId")
    private int attendanceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventId")
    private Event event;

    @Column(name="note")
    private int note;

    @Column(name="comment")
    private String comment;
}
