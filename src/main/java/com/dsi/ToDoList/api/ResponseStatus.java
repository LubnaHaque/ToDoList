package com.dsi.ToDoList.api;

public enum ResponseStatus {
    SUCCESS("SUCCESS"),
    ERROR("ERROR");

    private final String responseStatus;

    ResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseStatus() {
        return responseStatus;
    }
}
