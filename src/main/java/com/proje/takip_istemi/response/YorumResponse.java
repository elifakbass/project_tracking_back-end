package com.proje.takip_istemi.response;

public class YorumResponse {

    private String icerik;

    private int personel_id;
    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public int getPersonel_id() {
        return personel_id;
    }

    public void setPersonel_id(int personel_id) {
        this.personel_id = personel_id;
    }

    public YorumResponse(String icerik,int personel_id) {
        this.icerik = icerik;
        this.personel_id=personel_id;
    }
}
