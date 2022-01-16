package com.xxxx.hrhealthcheck.bean;

import java.util.List;

public class Company {
    private int id;
    private String companyName;
    private String businessSector;
    private String employeeNumber;
    private String companyLocation;
    private String contactName;
    private String contactJobTitle;
    private String contactEmail;
    private String contactTelephone;
    private List<AnswerCard> answerCard;
    public Company() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getBusinessSector() {
        return businessSector;
    }
    public void setBusinessSector(String businessSector) {
        this.businessSector = businessSector;
    }
    public String getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
    public String getCompanyLocation() {
        return companyLocation;
    }
    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public String getContactJobTitle() {
        return contactJobTitle;
    }
    public void setContactJobTitle(String contactJobTitle) {
        this.contactJobTitle = contactJobTitle;
    }
    public String getContactEmail() {
        return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public String getContactTelephone() {
        return contactTelephone;
    }
    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public List<AnswerCard> getAnswerCard() {
        return answerCard;
    }

    public void setAnswerCard(List<AnswerCard> answerCard) {
        this.answerCard = answerCard;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", businessSector='" + businessSector + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactJobTitle='" + contactJobTitle + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactTelephone='" + contactTelephone + '\'' +
                ", answerCard=" + answerCard +
                '}';
    }
}
