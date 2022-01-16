package com.xxxx.hrhealthcheck.bean;

import java.util.List;

public class Questionnaire {
    private int id;

    private String description;
    private boolean state;

    private List<Question> questions;
    private boolean completionStatus;
    public Questionnaire() {}
    public Questionnaire(int id, String description, boolean state, List<Question> questions, boolean completionStatus) {
        this.id = id;
        this.description = description;
        this.state = state;
        this.questions = questions;
        this.completionStatus = completionStatus;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Question> getQuestions() {
        return questions;
    }
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    public boolean isCompletionStatus() {
        return completionStatus;
    }
    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", state=" + state +
                ", questions=" + questions +
                ", completionStatus=" + completionStatus +
                '}';
    }
}
