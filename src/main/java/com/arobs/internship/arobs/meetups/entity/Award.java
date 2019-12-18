package com.arobs.internship.arobs.meetups.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name="awards")
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name="awardId")
    private int awardId;

    @Column(name="userId")
    private int userID;
    @Column(name="prizeId")
    private int prizeId;
    @Column(name="pointsNumber")
    private int pointsNumber;


}
