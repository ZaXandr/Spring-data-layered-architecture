package com.zakharov.springproject.exception;


public class WorkerNotFoundException extends RuntimeException {

    private String name;

    public WorkerNotFoundException(String message, String name) {
        super(message);
        this.name = name;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " " + name;
    }
}
