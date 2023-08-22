package com.proje.takip_istemi.response;

public class LoginMessage {
    String message;
    Boolean status;

    int role;

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LoginMessage(String message, Boolean status,int role) {
        this.message = message;
        this.status = status;
        this.role=role;
    }
    public LoginMessage(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
}