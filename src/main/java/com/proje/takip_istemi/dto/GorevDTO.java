package com.proje.takip_istemi.dto;

public class GorevDTO {

    private String name;

    private String durum;

    private String icerik;

    private String sonTarih;

    private int sorumlu;

    private int proje;

    public GorevDTO(){

    }

    public GorevDTO(String name, String durum, String icerik, String sonTarih, int sorumlu, int proje) {
        this.name = name;
        this.durum = durum;
        this.icerik = icerik;
        this.sonTarih = sonTarih;
        this.sorumlu = sorumlu;
        this.proje = proje;
    }

    public GorevDTO(String durum, String icerik, String sonTarih) {
        this.durum = durum;
        this.icerik = icerik;
        this.sonTarih = sonTarih;
    }

    public String getName() {
        return name;
    }

    public void setNme(String name) {
        this.name = name;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getSonTarih() {
        return sonTarih;
    }

    public void setSonTarih(String sonTarih) {
        this.sonTarih = sonTarih;
    }

    public int getSorumlu() {
        return sorumlu;
    }

    public void setSorumlu(int sorumlu) {
        this.sorumlu = sorumlu;
    }

    public int getProje() {
        return proje;
    }

    public void setProje(int proje) {
        this.proje = proje;
    }
}
