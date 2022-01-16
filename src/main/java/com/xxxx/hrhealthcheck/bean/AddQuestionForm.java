package com.xxxx.hrhealthcheck.bean;


import java.util.Arrays;

public class AddQuestionForm {
    private int questionnaireID;
    private int[] questionList;

    public AddQuestionForm() {
    }

    public AddQuestionForm(int questionnaireID, int[] questionList) {
        this.questionnaireID = questionnaireID;
        this.questionList = questionList;
    }

    public int getQuestionnaireID() {
        return questionnaireID;
    }

    public void setQuestionnaireID(int questionnaireID) {
        this.questionnaireID = questionnaireID;
    }

    public int[] getQuestionList() {
        return questionList;
    }

    public void setQuestionList(int[] questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "AddQuestionForm{" +
                "questionnaireID=" + questionnaireID +
                ", questionList=" + Arrays.toString(questionList) +
                '}';
    }
}
