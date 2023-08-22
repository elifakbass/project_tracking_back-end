package com.proje.takip_istemi.dto;

public class YorumDTO {
    int projeId;

    int personelId;

    String icerik;

    public int getProjeId() {
        return projeId;
    }

    public void setProjeId(int projeId) {
        this.projeId = projeId;
    }

    public int getPersonelId() {
        return personelId;
    }

    public void setPersonelId(int personelId) {
        this.personelId = personelId;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public YorumDTO(int projeId, int personelId, String icerik) {
        this.projeId = projeId;
        this.personelId = personelId;
        this.icerik = icerik;
    }
}
