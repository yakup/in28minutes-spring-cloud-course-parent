package com.in28minutes.course.masterspringcloud.controller.model;

public class HelloWorldBean {
    private final String message;

    public HelloWorldBean(String message) {
        this.message =message;
    }

    public String getMessage() {
        return message;
    }
}
