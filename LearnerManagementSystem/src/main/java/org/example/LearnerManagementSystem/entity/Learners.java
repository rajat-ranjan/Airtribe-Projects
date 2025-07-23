package org.example.LearnerManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Learners {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long learnerId;
    private String learnerName;
    private String learnerEmail;
    private String learnerPhone;
    @ManyToMany(mappedBy = "learnersList")//Cyclic reference
    @JsonIgnore
    private List<Cohorts> cohortsList;

    public Learners() {
        // Default constructor
    }

    public Learners(long learnerId, String learnerName, String learnerEmail, String learnerPhone) {
        this.learnerId = learnerId;
        this.learnerName = learnerName;
        this.learnerEmail = learnerEmail;
        this.learnerPhone = learnerPhone;
    }

    public long getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(long learnerId) {
        this.learnerId = learnerId;
    }

    public String getLearnerName() {
        return learnerName;
    }

    public void setLearnerName(String learnerName) {
        this.learnerName = learnerName;
    }

    public String getLearnerEmail() {
        return learnerEmail;
    }

    public void setLearnerEmail(String learnerEmail) {
        this.learnerEmail = learnerEmail;
    }

    public String getLearnerPhone() {
        return learnerPhone;
    }

    public void setLearnerPhone(String learnerPhone) {
        this.learnerPhone = learnerPhone;
    }

    public List<Cohorts> getCohortsList() {
        return cohortsList;
    }

    public void setCohortsList(List<Cohorts> cohortsList) {
        this.cohortsList = cohortsList;
    }
}
