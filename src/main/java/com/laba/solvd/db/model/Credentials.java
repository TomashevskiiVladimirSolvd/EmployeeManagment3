package com.laba.solvd.db.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credentials that = (Credentials) o;
        return id == that.id && Objects.equals(login, that.login) && Objects.equals(password, that.password) && Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, employee);
    }
}
