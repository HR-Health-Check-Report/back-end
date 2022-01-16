package com.xxxx.hrhealthcheck.bean;

public class Middle {
    private int questionnaire_id;
    private int question_id;

    public Middle() {
    }

    public Middle(int questionnaire_id, int question_id) {
        this.questionnaire_id = questionnaire_id;
        this.question_id = question_id;
    }

    public int getQuestionnaire_id() {
        return questionnaire_id;
    }

    public void setQuestionnaire_id(int questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    @Override
    public String toString() {
        return "Middle{" +
                "questionnaire_id=" + questionnaire_id +
                ", question_id=" + question_id +
                '}';
    }
}
