package com.digital.coffee.shop.dto.object;

import java.util.List;

public class BaseResponseBody {
    private Integer statusCode;
    private List<String> messages;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
