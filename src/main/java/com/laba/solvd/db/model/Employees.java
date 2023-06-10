package com.laba.solvd.db.model;

public class Employees {
    private long id;
    private String name;
    private String position;
    private Contacts contact;
    private Credentials credentials;
    public Employees(){};

    public Employees(long id,String name,String position){
        this.id=id;
        this.name=name;
        this.position=position;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public Contacts getContact() {
        return contact;
    }

    public void setContact(Contacts contact) {
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
