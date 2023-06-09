package com.laba.solvd.db.domain;

import java.util.List;

public class Employees {
    private long id;
    private String name;
    private String position;
    private List<EmployeesTasks> employeesTasks;
    private List<EmployeesSkills> employeesSkills;
    private List<EmployeesTrainings> employeesTrainings;

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
