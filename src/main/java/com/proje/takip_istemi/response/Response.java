package com.proje.takip_istemi.response;

public class Response {
    String message;
    Boolean status;

    String[] mesaj;

    public String[] getMesaj() {
        return mesaj;
    }

    public void setMesaj(String[] mesaj) {
        this.mesaj = mesaj;
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

    public Response(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public Response(String[] mesaj, Boolean status) {
        this.mesaj = mesaj;
        this.status = status;
    }
}
