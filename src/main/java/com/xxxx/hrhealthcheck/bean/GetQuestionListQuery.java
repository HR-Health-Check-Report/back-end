package com.xxxx.hrhealthcheck.bean;

import java.util.Arrays;

public class GetQuestionListQuery {
    private int groupId ;
    private int[] questionIds;
    private int questionnaireId;

    public GetQuestionListQuery() {
    }

    public GetQuestionListQuery(int groupId, int[] questionIds, int questionnaireId) {

        this.groupId = groupId;
        this.questionIds = questionIds;
        this.questionnaireId = questionnaireId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int[] getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(int[] questionIds) {
        this.questionIds = questionIds;
    }

    public int getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(int questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    @Override
    public String toString() {
        return "GetQuestionListQuery{" +
                "groupId=" + groupId +
                ", questionIds=" + Arrays.toString(questionIds) +
                ", questionnaireId=" + questionnaireId +
                '}';
    }
}
