package org.example.LearnerManagementSystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cohorts {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long cohortId;
    private String cohortName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Learners> learnersList;

    @ManyToOne
    private Course course;

    public Cohorts() {
    }

    public Cohorts(long cohortId, String cohortName) {
        this.cohortId = cohortId;
        this.cohortName = cohortName;
    }

    public long getCohortId() {
        return cohortId;
    }

    public void setCohortId(long cohortId) {
        this.cohortId = cohortId;
    }

    public String getCohortName() {
        return cohortName;
    }

    public void setCohortName(String cohortName) {
        this.cohortName = cohortName;
    }

    public List<Learners> getLearnersList() {
        return learnersList;
    }

    public void setLearnersList(List<Learners> learnersList) {
        this.learnersList = learnersList;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
