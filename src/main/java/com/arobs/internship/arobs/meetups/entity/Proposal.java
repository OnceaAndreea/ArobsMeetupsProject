package com.arobs.internship.arobs.meetups.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name="proposals")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name="proposalId")
    private int proposalId;

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

    @Column(name="maxAttendees")
    private int maxAttendees;



    public Proposal(int proposalId, String title, String description, String type, String difficulty, String language, int duration, int maxAttendees) {
        this.proposalId = proposalId;
        this.title = title;
        this.description = description;
        this.type = type;
        this.difficulty = difficulty;
        this.language = language;
        this.duration = duration;
        this.maxAttendees = maxAttendees;
    }

    public int getId() {
        return proposalId;
    }

    public void setId(int proposalId) {
        this.proposalId = proposalId;
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

    public int getmaxAtendees() {
        return maxAttendees;
    }

    public void setmaxAtendees(int maxAtendees) {
        this.maxAttendees = maxAtendees;
    }


}
