package com.rakib.mail_service.controller;

import com.rakib.mail_service.model.EmailStatus;
import com.rakib.mail_service.model.Patient;
import com.rakib.mail_service.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
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
        ArrayList<Patient> mailAddress = new ArrayList<>();
        Patient p1 = new Patient("Rakib", "rakibccj@gmail.com", false);
        Patient p2 = new Patient("Test", "atuar.cse@gmail.com", false);
        mailAddress.add(p1);
        mailAddress.add(p2);
        for (Patient patient : mailAddress) {
            sms = mailService.sendMimeMail(patient.getEmail(), "COVID - 19 TEST RESULT", Boolean.toString(patient.getResult()));
            if (sms.getErrorMessage() == null) {

            } else {

            }
        }
        return sms;
    }
}
