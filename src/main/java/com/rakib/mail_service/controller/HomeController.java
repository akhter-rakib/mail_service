package com.rakib.mail_service.controller;

import com.rakib.mail_service.model.EmailStatus;
import com.rakib.mail_service.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class HomeController {

    @Autowired
    MailService mailService;
    EmailStatus sms = null;

    @RequestMapping(value = "/sendmail")
    public EmailStatus sendMail() {
        ArrayList<String> mailAddress = new ArrayList<>();
        mailAddress.add("rakibccj@gmail.com");
        mailAddress.add("farzana.cse15@gmail.com");
        for (String mail : mailAddress) {
            sms = mailService.sendMimeMail(mail, "COVID - 19 TEST Result", "NEGETIVE");
        }
        return sms;
    }
}
