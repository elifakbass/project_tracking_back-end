package com.proje.takip_istemi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "personel")
public class Personel {

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

    @Column(name = "department")
    private String department;

    @Column(name = "unvan")
    private String unvan;

    @Column(name = "yetkinlikler")
    private String yetkinlikler;


    @Column(name = "image")
    private String image;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "personel_proje",
            joinColumns = @JoinColumn(name = "personel_id"),
            inverseJoinColumns = @JoinColumn(name = "proje_id"))
    private List<Proje> projeler;

    @OneToMany(mappedBy = "personel")
    private List<Gorev> gorevler;

    @OneToMany(mappedBy = "personel")
    private List<Yorum> yorumlar;


    @ManyToOne
    @JoinColumn(name = "yonetici_id")
    private Yonetici yonetici;

    public List<Gorev> getGorevler() {
        return gorevler;
    }

    public void setGorevler(List<Gorev> gorevler) {
        this.gorevler = gorevler;
    }

    public Yonetici getYonetici() {
        return yonetici;
    }

    public void setYonetici(Yonetici yonetici) {
        this.yonetici = yonetici;
    }





    public Personel(){

    }

    public Personel(String name,String email, String password, String department, String unvan, String yetkinlikler, String image) {
        this.name=name;
        this.email = email;
        this.password = password;
        this.department = department;
        this.unvan = unvan;
        this.yetkinlikler = yetkinlikler;
        this.image = image;
    }

    public Personel(String name, String department, String unvan, String yetkinlikler) {
        this.name = name;
        this.department = department;
        this.unvan = unvan;
        this.yetkinlikler = yetkinlikler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getYetkinlikler() {
        return yetkinlikler;
    }

    public void setYetkinlikler(String yetkinlikler) {
        this.yetkinlikler = yetkinlikler;
    }

    public List<Proje> getProjeler() {
        return projeler;
    }

    public void setProjeler(List<Proje> projeler) {
        this.projeler = projeler;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Yorum> getYorumlar() {
        return yorumlar;
    }

    public void setYorumlar(List<Yorum> yorumlar) {
        this.yorumlar = yorumlar;
    }

    @Override
    public String toString() {
        return "Personel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", unvan='" + unvan + '\'' +
                ", yetkinlikler='" + yetkinlikler + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
