package com.rakib.mail_service.service;

import com.rakib.mail_service.model.EmailStatus;
import com.rakib.mail_service.model.MailConstraint;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    public EmailStatus sendMimeMail(String to, String subject, String text) {
        try {
            Session session = MailConstraint.getSessionInstance();
            MimeMessage message = new MimeMessage(session);
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(new InternetAddress(MailConstraint.from));
            helper.setTo(to);
            System.out.println("receiver " + to);
            helper.setSubject(subject);
            helper.setText(text);
            System.out.println("RESULT INFO " + text);
            Transport.send(message);
            System.out.println("Send email to : " + to);
            return new EmailStatus(to, subject, text).success();
        } catch (Exception e) {
            System.out.println("Problem with sending email to: " + to + " error message: " + e.getMessage());
            return new EmailStatus(to, subject, text).error(e.getMessage());
        }
    }
}
