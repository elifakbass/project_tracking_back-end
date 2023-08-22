package com.proje.takip_istemi.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Entity
@Table(name = "proje")
public class Proje {

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


    @OneToMany(mappedBy = "proje",cascade = CascadeType.ALL)
    private List<Gorev> gorevler;

    @OneToMany(mappedBy = "proje",cascade = CascadeType.ALL)
    private List<Yorum> yorumlar;



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "personel_proje",
            joinColumns = @JoinColumn(name = "proje_id"),
            inverseJoinColumns = @JoinColumn(name = "personel_id")
    )
    private List<Personel> personel;



    public Proje(){


    }

    public Proje(String name, String sonTarih, String durum, String icerik) {
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

    public List<Gorev> getGorevler() {
        return gorevler;
    }

    public void setGorevler(List<Gorev> gorevler) {
        this.gorevler = gorevler;
    }

    public List<Personel> getPersonel() {
        return personel;
    }

    public void setPersonel(List<Personel> personel) {
        this.personel = personel;
    }

    public List<Yorum> getYorumlar() {
        return yorumlar;
    }

    public void setYorumlar(List<Yorum> yorumlar) {
        this.yorumlar = yorumlar;
    }

    public void addPersonel(Personel p){
        if(personel== null){
            personel=new ArrayList<>();
        }
        personel.add(p);


    }

    @Override
    public String toString() {
        return "Proje{" +
                "id=" + id +
                ", name=" + name +
                ", sonTarih='" + sonTarih + '\'' +
                ", durum='" + durum + '\'' +
                ", icerik='" + icerik + '\'' +
                '}';
    }
}
