package com.xxxx.hrhealthcheck.bean;

public class Question {
    private int id;
    private String question;
    private int type;
    private boolean state;
    private QuestionType questionType;

    public Question() {
    }

    public Question(int id, String question, int type, boolean state, QuestionType questionType) {
        this.id = id;
        this.question = question;
        this.type = type;
        this.state = state;
        this.questionType = questionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getType() {
        return type;
    }

    public final void setType(int type) {
        this.type = type;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", type=" + type +
                ", state=" + state +
                ", questionType=" + questionType +
                '}';
    }
}
