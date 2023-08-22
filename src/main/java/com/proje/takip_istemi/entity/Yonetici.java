package com.proje.takip_istemi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "yonetici")
public class Yonetici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "kurum_adi")
    private String kurumAdi;

    @Column(name = "personel_sayisi")
    private int personelSayisi;

    @Column(name = "image")
    private String image;


    @OneToMany(mappedBy = "yonetici")
    private List<Personel> personelList;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST ,CascadeType.REFRESH })
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Yonetici(){

    }

    public Yonetici(String name, String email, String password, String kurumAdi, int personelSayisi) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.kurumAdi = kurumAdi;
        this.personelSayisi = personelSayisi;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKurumAdi() {
        return kurumAdi;
    }

    public void setKurumAdi(String kurumAdi) {
        this.kurumAdi = kurumAdi;
    }

    public int getPersonelSayisi() {
        return personelSayisi;
    }

    public void setPersonelSayisi(int personelSayisi) {
        this.personelSayisi = personelSayisi;
    }

    public List<Personel> getPersonelList() {
        return personelList;
    }

    public void setPersonelList(List<Personel> personelList) {
        this.personelList = personelList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "Yonetici{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", kurumAdi='" + kurumAdi + '\'' +
                ", personelSayisi='" + personelSayisi + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
