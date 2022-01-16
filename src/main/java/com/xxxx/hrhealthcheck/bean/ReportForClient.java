package com.xxxx.hrhealthcheck.bean;

public class ReportForClient {
    private String group1;
    private String group2;
    private String group3;
    private String group4;
    private String group5;
    private String group6;
    private String group7;
    private String group8;
    private String group9;
    private String group10;
    private String group11;
    private String group12;
    private String group13;

    public void setReportPart(int i,String content){
        switch (i){
            case 1:
                this.group1 = content;
                break;
            case 2:
                this.group2 = content;
                break;
            case 3:
                this.group3 = content;
                break;
            case 4:
                this.group4 = content;
                break;
            case 5:
                this.group5 = content;
                break;
            case 6:
                this.group6 = content;
                break;
            case 7:
                this.group7 = content;
                break;
            case 8:
                this.group8 = content;
                break;
            case 9:
                this.group9 = content;
                break;
            case 10:
                this.group10 = content;
                break;
            case 11:
                this.group11 = content;
                break;
            case 12:
                this.group12 = content;
                break;
            case 13:
                this.group13 = content;
                break;
        }

    }

    @Override
    public String toString() {
        return "Report{" +
                "group1='" + group1 + '\'' +
                ", group2='" + group2 + '\'' +
                ", group3='" + group3 + '\'' +
                ", group4='" + group4 + '\'' +
                ", group5='" + group5 + '\'' +
                ", group6='" + group6 + '\'' +
                ", group7='" + group7 + '\'' +
                ", group8='" + group8 + '\'' +
                ", group9='" + group9 + '\'' +
                ", group10='" + group10 + '\'' +
                ", group11='" + group11 + '\'' +
                ", group12='" + group12 + '\'' +
                ", group13='" + group13 + '\'' +
                '}';
    }
}
