package com.proje.takip_istemi.dto;

public class YoneticiDTO {

    int id;

    int admin_id;

    String name;

    String email;

    String password;

    String kurumAdi;

    int personelSayisi;

    String image;

    public YoneticiDTO (){

    }

    public YoneticiDTO(int id, String name, String kurumAdi, int personelSayisi, String image) {
        this.id = id;
        this.name = name;
        this.kurumAdi = kurumAdi;
        this.personelSayisi = personelSayisi;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
}
