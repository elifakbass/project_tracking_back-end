package com.proje.takip_istemi.dto;

public class PersonelDTO {

    String name;
    String email;

    String password;

    String department;

    String unvan;

    String yetkinlikler;

    int yonetici_id;

    String image;

    public PersonelDTO(String name,String email, String password, String department, String unvan, String yetkinlikler, int yonetici_id, String image) {
        this.name=name;
        this.email = email;
        this.password = password;
        this.department = department;
        this.unvan = unvan;
        this.yetkinlikler = yetkinlikler;
        this.yonetici_id = yonetici_id;
        this.image = image;
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

    public int getYonetici_id() {
        return yonetici_id;
    }

    public void setYonetici_id(int yonetici_id) {
        this.yonetici_id = yonetici_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
