package com.rakib.mail_service.service;

import com.rakib.mail_service.config.ActiveStatus;
import com.rakib.mail_service.model.Patient;

import javax.persistence.*;

@Entity
public class MailTransaction {
    @Id
    private Integer id;
    @OneToOne
    @JoinColumn(name = "patient_ID")
    private Patient patient;
    private int active;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
