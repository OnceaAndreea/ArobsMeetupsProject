package com.arobs.internship.arobs.meetups.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="prizes")
public class Prize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name="prizeId")
    private int prizeId;

    @Column(name="description")
    private String despription;

    @Column(name="value")
    private String value;

    //one prize can appear in many awarding histories
    @OneToMany(
            mappedBy = "prize",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<AwardingHistory> awards = new ArrayList<>();
}
