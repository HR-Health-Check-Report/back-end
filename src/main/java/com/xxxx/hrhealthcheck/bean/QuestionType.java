package com.xxxx.hrhealthcheck.bean;

import java.util.List;

public class QuestionType {

    private int id;
    private String description;
    private boolean state;
    private List<Question> questions;

    public QuestionType() {
    }

    public QuestionType(int id, String description, boolean state, List<Question> questions) {
        this.id = id;
        this.description = description;
        this.state = state;
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id ;
    }

    public String getDescription() {
        return description;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
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

    @Override
    public String toString() {
        return "QuestionType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", state=" + state +
                ", questions=" + questions +
                '}';
    }
}
