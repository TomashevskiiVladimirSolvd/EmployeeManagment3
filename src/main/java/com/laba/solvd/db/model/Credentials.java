package com.laba.solvd.db.model;

public class Credentials {
    private long id;
    private String login;
    private String password;
    private Employees employee;
    public Credentials(){};

    public Credentials(long id,String login,String password){
        this.id=id;
        this.login=login;
        this.password=password;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
