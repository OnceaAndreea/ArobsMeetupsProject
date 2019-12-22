package com.arobs.internship.arobs.meetups.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name="awardingHistory")
public class AwardingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name="awardingId")
    private int awardingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prizeId")
    private Prize prize;

    @Column(name="pointsNumber")
    private int pointsNumber;

    public int getAwardingId() {
        return awardingId;
    }

    public void setAwardingId(int awardId) {
        this.awardingId = awardId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Prize getPrize() {
        return prize;
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }

    public int getPointsNumber() {
        return pointsNumber;
    }

    public void setPointsNumber(int pointsNumber) {
        this.pointsNumber = pointsNumber;
    }
}
