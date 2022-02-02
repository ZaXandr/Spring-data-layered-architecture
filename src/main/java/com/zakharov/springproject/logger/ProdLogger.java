package com.zakharov.springproject.logger;

public class ProdLogger implements Logger {
    @Override
    public void logMessage(String message) {
        System.out.println("Prod: " + message);
    }
}
