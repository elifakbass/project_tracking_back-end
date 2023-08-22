package com.proje.takip_istemi.response;

public class GorevResponse {
    int id;

    String name;
    String durum;
    String icerik;
    String sonTarih;


    int sorumlu;

    int proje;



    boolean status;

    String mesaj;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public GorevResponse(int id, String name, String durum, String icerik, String sonTarih,int sorumlu,Boolean status,int proje) {
        this.id = id;
        this.name = name;
        this.durum = durum;
        this.icerik = icerik;
        this.sonTarih = sonTarih;
        this.status=status;
        this.sorumlu=sorumlu;
        this.proje=proje;

    }
}
