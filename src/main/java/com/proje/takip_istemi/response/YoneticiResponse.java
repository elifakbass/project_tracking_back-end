package com.proje.takip_istemi.response;

import com.proje.takip_istemi.dto.YoneticiDTO;

public class YoneticiResponse {
    YoneticiDTO yonetici;

    String mesaj;

    public YoneticiDTO getYonetici() {
        return yonetici;
    }

    public void setYonetici(YoneticiDTO yonetici) {
        this.yonetici = yonetici;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public YoneticiResponse(YoneticiDTO yonetici) {
        this.yonetici = yonetici;
    }

    public YoneticiResponse(String mesaj) {
        this.mesaj = mesaj;
    }
}
