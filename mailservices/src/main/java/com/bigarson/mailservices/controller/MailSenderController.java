package com.bigarson.mailservices.controller;

import com.bigarson.mailservices.base.BaseController;
import com.bigarson.mailservices.models.requestmodel.RequestMailSender;
import com.bigarson.mailservices.models.responsemodel.ResponseMailSender;
import com.bigarson.mailservices.services.MailSenderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class MailSenderController extends BaseController {

    @Autowired
    MailSenderServices mailServices;

    @PostMapping("/mailsender")
    public ResponseEntity<ResponseMailSender> hello(@RequestBody RequestMailSender request) {
        ResponseMailSender response = new ResponseMailSender();
        try {
            mailServices.sendEmail(request.getTo(),request.getSubject(), request.getModel());
            response.setMessage("Mail Gönderimi Başarılı.");
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            response.setMessage(e.toString());
            return  new ResponseEntity<> (response, HttpStatus.BAD_REQUEST);
        }
    }
}