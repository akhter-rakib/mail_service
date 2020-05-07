package com.rakib.mail_service.model;

public class MailTransaction {
    private Integer id;
    private MailReceiver mailReceiver;
    private Boolean mailStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MailReceiver getMailReceiver() {
        return mailReceiver;
    }

    public void setMailReceiver(MailReceiver mailReceiver) {
        this.mailReceiver = mailReceiver;
    }

    public Boolean getMailStatus() {
        return mailStatus;
    }

    public void setMailStatus(Boolean mailStatus) {
        this.mailStatus = mailStatus;
    }
}
