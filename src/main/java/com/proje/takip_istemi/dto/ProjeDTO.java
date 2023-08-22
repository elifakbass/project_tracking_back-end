package com.proje.takip_istemi.dto;

public class ProjeDTO {

    private String name;

    private String sonTarih;

    private String durum;

    private String icerik;

    private int sorumlu;


    public ProjeDTO(){

    }

    public ProjeDTO(String name, String sonTarih, String durum, String icerik, int sorumlu) {
        this.name = name;
        this.sonTarih = sonTarih;
        this.durum = durum;
        this.icerik = icerik;
        this.sorumlu = sorumlu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSonTarih() {
        return sonTarih;
    }

    public void setSonTarih(String sonTarih) {
        this.sonTarih = sonTarih;
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

    public int getSorumlu() {
        return sorumlu;
    }

    public void setSorumlu(int sorumlu) {
        this.sorumlu = sorumlu;
    }

}
