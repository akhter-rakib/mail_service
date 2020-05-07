package com.rakib.mail_service.service;

import com.rakib.mail_service.model.EmailStatus;
import com.rakib.mail_service.model.MailConstraint;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
public class MailService {
    public EmailStatus sendMimeMail(String to, String subject, String text, Boolean isHtml, List<File> attachments) {
        try {
            Session session = MailConstraint.getSessionInstance();
            MimeMessage message = new MimeMessage(session);
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(MailConstraint.USERNAME);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, isHtml);
            if (attachments != null && attachments.size() > 0) {
                for (File file : attachments) {
                    helper.addAttachment(file.getName(), file);
                }
            }
            Transport.send(message);
            System.out.println("Send email to: " + to);
            return new EmailStatus(to, subject, text).success();
        } catch (Exception e) {
            System.out.println("Problem with sending email to: " + to + " error message: " + e.getMessage());
            return new EmailStatus(to, subject, text).error(e.getMessage());
        }
    }

    public EmailStatus sendHtmlMail(String to, String subject, String text, List<File> attachments) {
        return sendMimeMail(to, subject, text, true, attachments);
    }

    public EmailStatus sendHtmlMail(String to, String subject, String text) {
        return sendMimeMail(to, subject, text, true, null);
    }

    public EmailStatus sendNonHtmlMail(String to, String subject, String text) {
        return sendMimeMail(to, subject, text, false, null);
    }

    public EmailStatus sendNonHtmlMail(String to, String subject, String text, List<File> attachments) {
        return sendMimeMail(to, subject, text, false, attachments);
    }
}
