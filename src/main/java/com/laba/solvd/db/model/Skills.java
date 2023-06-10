package com.laba.solvd.db.model;

import java.util.List;

public class Skills {
    private long id;
    private String name;
    private List<EmployeesSkills> employees;

    public Skills(){};

    public Skills(long id, String name){
        this.id=id;
        this.name=name;
    }

    public List<EmployeesSkills> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeesSkills> employees) {
        this.employees = employees;
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
}
