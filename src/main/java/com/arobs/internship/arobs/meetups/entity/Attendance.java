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

    @Column(name="userId")
    private int userId;
    @Column(name="eventId")
    private int eventId;
    @Column(name="note")
    private int note;
    @Column(name="comment")
    private String comment;
}
