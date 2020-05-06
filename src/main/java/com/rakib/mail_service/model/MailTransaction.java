package com.rakib.mail_service.model;

public class MailTransaction {
    private Integer id;
    private Patient patient;
    private Boolean mailStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Boolean getMailStatus() {
        return mailStatus;
    }

    public void setMailStatus(Boolean mailStatus) {
        this.mailStatus = mailStatus;
    }
}
