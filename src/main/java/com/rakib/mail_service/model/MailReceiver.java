package com.rakib.mail_service.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MailReceiver {
    @Id
    private Integer id;
    private String name;
    private String email;
    private Boolean result;

    public MailReceiver() {

    }

    public MailReceiver(String name, String email, Boolean result) {
        this.name = name;
        this.email = email;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
