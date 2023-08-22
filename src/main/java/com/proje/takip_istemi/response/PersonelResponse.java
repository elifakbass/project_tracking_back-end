package com.proje.takip_istemi.response;

public class PersonelResponse {
    int id;
    String name;

    String department;

    String unvan;

    String image;

    String yetkinlikler;

    String mesaj;

    int sorumlu;

    public int getSorumlu() {
        return sorumlu;
    }

    public void setSorumlu(int sorumlu) {
        this.sorumlu = sorumlu;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getYetkinlikler() {
        return yetkinlikler;
    }

    public void setYetkinlikler(String yetkinlikler) {
        this.yetkinlikler = yetkinlikler;
    }
    public  PersonelResponse() {

    }

    public PersonelResponse(int id, String name, String department, String unvan, String image, String yetkinlikler,int sorumlu) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.unvan = unvan;
        this.image = image;
        this.yetkinlikler = yetkinlikler;
        this.sorumlu=sorumlu;
    }

    public PersonelResponse(String mesaj) {
        this.mesaj = mesaj;
    }
}
