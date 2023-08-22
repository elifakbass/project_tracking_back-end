package com.proje.takip_istemi.dto;

public class DurumDTO {
    String durum;

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
    public DurumDTO(){

    }

    public DurumDTO(String durum) {
        this.durum = durum;
    }
}
