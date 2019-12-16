package com.arobs.internship.arobs.meetups.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;

@JsonFormat
@Entity
public class Proposal {

    private int proposalId;
    private int userId;
    private String title;
    private String description;
    private String type;
    private String difficulty;
    private String language;
    private int duration;
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

    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
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
