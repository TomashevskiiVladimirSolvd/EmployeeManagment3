package com.laba.solvd.db.model;

public class Contacts {
    private long id;
    private String email;
    private String phone;
    private Employees employee;

    public Contacts(){};

    public Contacts(long id,String email,String phone){
        this.id=id;
        this.email=email;
        this.phone=phone;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
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
