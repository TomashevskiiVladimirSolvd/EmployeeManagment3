package com.laba.solvd.db.model;

public class Contacts {
    private long id;
    private String email;
    private String phone;

    public Contacts(){};

    public Contacts(long id,String email,String phone){
        this.id=id;
        this.email=email;
        this.phone=phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
