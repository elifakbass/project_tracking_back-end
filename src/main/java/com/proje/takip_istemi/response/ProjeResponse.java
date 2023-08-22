package com.proje.takip_istemi.response;

public class ProjeResponse {

    int id;

    String name;
    String durum;
    String icerik;
    String sonTarih;


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

    public ProjeResponse(int id, String name, String durum, String icerik, String sonTarih,Boolean status) {
        this.id = id;
        this.name = name;
        this.durum = durum;
        this.icerik = icerik;
        this.sonTarih = sonTarih;
        this.status=status;

    }

    public ProjeResponse(boolean status, String mesaj) {
        this.status = status;
        this.mesaj = mesaj;
    }


}
