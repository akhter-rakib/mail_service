package com.rakib.mail_service.controller;

import com.rakib.mail_service.model.EmailStatus;
import com.rakib.mail_service.model.MailReceiver;
import com.rakib.mail_service.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    MailService mailService;
    EmailStatus sms = null;
    static final String fixedFileLocation = "C://Users//aman//Desktop//Form//";

    @RequestMapping(value = "/report")
    public String report() {
        return "reportView";
    }

    @RequestMapping(value = "/sendmail")
    public EmailStatus sendMail() {
        ArrayList<MailReceiver> mailAddress = new ArrayList<>();
        MailReceiver p1 = new MailReceiver("Rakib", "rakibccj@gmail.com", false);
        mailAddress.add(p1);

        //File
        String fileName = "234";
        String fileLocation = fixedFileLocation + fileName + ".pdf";
        File file = new File(fileLocation);
        List<File> attached = new ArrayList();
        attached.add(file);

        for (MailReceiver mailReceiver : mailAddress) {
            sms = mailService.sendMimeMail(mailReceiver.getEmail(), "COVID - 19 TEST RESULT", Boolean.toString(mailReceiver.getResult()), false, attached);
            if (sms.getErrorMessage() == null) {

            } else {

            }
        }
        return sms;
    }
}
