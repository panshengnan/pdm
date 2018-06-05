package com.cgwx.data.dto;

public class UserRequirementInfoSubmitted {

    private String status;
    private String message;
    private UserRequirementDetail data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserRequirementDetail getData() {
        return data;
    }

    public void setData(UserRequirementDetail data) {
        this.data = data;
    }
}
