package com.rakib.mail_service.model;

import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class MailConstraint {
    private MailConstraint() {

    }

    public static final String from = "rakibccj@gmail.com";
    public static final String USERNAME = "rakibccj@gmail.com";
    public static final String PASSWORD = "Your password";
    public static final Integer PORT = 587;
    public static final String HOST = "smtp.gmail.com";
    public static final String IS_AUTH = "true";
    public static final String IS_TLS = "true";

    public static Properties getPropertiesInstance() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", PORT);
        properties.put("mail.smtp.auth", IS_AUTH);
        properties.put("mail.smtp.starttls.enable", IS_TLS);
        return properties;
    }

    public static Session getSessionInstance() {
        return Session.getInstance(getPropertiesInstance(), new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
    }
}
