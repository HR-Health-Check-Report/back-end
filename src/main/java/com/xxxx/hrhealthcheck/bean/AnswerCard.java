package com.xxxx.hrhealthcheck.bean;

import java.util.List;

public class AnswerCard {
    private String group;
    private List<Answer> answerList;

    public AnswerCard() {
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "AnswerCard{" +
                "group='" + group + '\'' +
                ", answerList=" + answerList +
                '}';
    }
}
