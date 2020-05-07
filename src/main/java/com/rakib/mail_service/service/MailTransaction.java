package com.rakib.mail_service.service;

import com.rakib.mail_service.config.ActiveStatus;
import com.rakib.mail_service.model.MailReceiver;

import javax.persistence.*;

@Entity
public class MailTransaction {
    @Id
    private Integer id;
    @OneToOne
    @JoinColumn(name = "patient_ID")
    private MailReceiver mailReceiver;
    private int active;

    public MailReceiver getMailReceiver() {
        return mailReceiver;
    }

    public void setMailReceiver(MailReceiver mailReceiver) {
        this.mailReceiver = mailReceiver;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @PrePersist
    public void prePersist() {
        this.active = ActiveStatus.ACTIVE.getValue();
    }

}
