package com.proje.takip_istemi.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "yorum")
public class Yorum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "proje_id")
    private Proje proje;

    @ManyToOne
    @JoinColumn(name = "personel_id")
    private Personel personel;

    @Column(name = "icerik")
    private String icerik;

    public Yorum(){

    }

    public Yorum( String icerik) {
        this.icerik = icerik;
    }


    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Proje getProje() {
        return proje;
    }

    public void setProje(Proje proje) {
        this.proje = proje;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    @Override
    public String toString() {
        return "Yorum{" +
                "id=" + id +
                ", proje=" + proje +
                ", icerik='" + icerik + '\'' +
                '}';
    }
}
