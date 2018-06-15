package com.example.business.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author yuanweipeng
 * @date 2018-02-08
 **/
public class CustomApplicationEvent extends ApplicationEvent{

    private static final long serialVersionUID = 1L;

    private String message;

    CustomApplicationEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
