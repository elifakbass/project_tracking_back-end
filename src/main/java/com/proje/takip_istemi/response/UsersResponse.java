package com.proje.takip_istemi.response;

public class UsersResponse {

    int id;

    String email;

    String image;

    public UsersResponse(){

    }

    public UsersResponse(int id, String email, String image) {
        this.id = id;
        this.email = email;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
