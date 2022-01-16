package com.xxxx.hrhealthcheck.bean;

public class ReportForDatabase {
    private int id;
    private String report;
    private int totalScore;
    private String companyName;

    public ReportForDatabase( String report, int totalScore, String companyName) {
        this.report = report;
        this.totalScore = totalScore;
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "ReportForDatabase{" +
                "id=" + id +
                ", report='" + report + '\'' +
                ", totalScore=" + totalScore +
                ", companyName=" + companyName +
                '}';
    }
}
