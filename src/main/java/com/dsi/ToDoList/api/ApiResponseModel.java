package com.dsi.ToDoList.api;

import java.util.Map;

public class ApiResponseModel {
    private ResponseStatus responseStatus;
    Map<String, Object> payload;

    public ApiResponseModel() {
    }

    public ApiResponseModel(ResponseStatus responseStatus, Map<String, Object> payload) {
        this.responseStatus = responseStatus;
        this.payload = payload;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }
}
