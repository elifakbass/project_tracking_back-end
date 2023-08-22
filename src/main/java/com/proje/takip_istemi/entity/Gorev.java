package com.proje.takip_istemi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "gorev")
public class Gorev {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "son_tarih")
    private String sonTarih;

    @Column(name = "durum")
    private String durum;

    @Column(name = "icerik")
    private String icerik;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST ,CascadeType.REFRESH })
    @JoinColumn(name = "sorumlu_id")
    private Personel personel;

    @ManyToOne()
    @JoinColumn(name = "proje_id")
    private Proje proje;



    public Gorev(){

    }

    public Gorev(String name, String sonTarih, String durum, String icerik) {
        this.name = name;
        this.sonTarih = sonTarih;
        this.durum = durum;
        this.icerik = icerik;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    public Proje getProje() {
        return proje;
    }

    public void setProje(Proje proje) {
        this.proje = proje;
    }

    @Override
    public String toString() {
        return "Gorev{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sonTarih='" + sonTarih + '\'' +
                ", durum='" + durum + '\'' +
                ", icerik='" + icerik + '\'' +
                '}';
    }
}
