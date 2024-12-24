package com.multibranch.app.entities.enume;

public enum EInterceptor {
    REQUEST("REQUEST"),
    RESPONSE("RESPONSE");

    private String message;

    private EInterceptor(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}

