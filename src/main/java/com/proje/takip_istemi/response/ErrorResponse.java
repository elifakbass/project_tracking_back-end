package com.proje.takip_istemi.response;

public class ErrorResponse {

    private boolean success;

    private String mesaj;

    public ErrorResponse(){

    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public ErrorResponse(boolean success, String mesaj) {
        this.success = success;
        this.mesaj = mesaj;
    }
}
