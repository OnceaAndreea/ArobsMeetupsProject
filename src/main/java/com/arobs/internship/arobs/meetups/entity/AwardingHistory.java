package com.arobs.internship.arobs.meetups.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name="awardingHistory")
public class AwardingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name="awardId")
    private int awardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prizeId")
    private Prize prize;

    @Column(name="pointsNumber")
    private int pointsNumber;


}
