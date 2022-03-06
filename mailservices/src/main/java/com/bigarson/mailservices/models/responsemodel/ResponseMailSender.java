package com.bigarson.mailservices.models.responsemodel;

import com.bigarson.mailservices.base.BaseResponse;

public class ResponseMailSender extends BaseResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
