package com.bigarson.mailservices.models.requestmodel;

import com.bigarson.mailservices.base.BaseRequest;

import java.util.HashMap;

public class RequestMailSender extends BaseRequest {
    private String to;
    private String subject;
    private HashMap<String,String> model;

    // Getter Methods

    public HashMap<String, String> getModel() {
        return model;
    }

    public void setModel(HashMap<String, String> model) {
        this.model = model;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    // Setter Methods

    public void setTo(String to) {
        this.to = to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
