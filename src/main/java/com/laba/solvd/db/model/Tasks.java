package com.laba.solvd.db.model;

import java.util.List;

public class Tasks {
    private long id;
    private String name;
    private String priority;
    private List<EmployeesTasks> employees;
    private Projects projects;

    public Tasks(){};

    public Tasks(long id, String name, String priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    public Projects getProjects() {
        return projects;
    }

    public void setProjects(Projects projects) {
        this.projects = projects;
    }

    public List<EmployeesTasks> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeesTasks> employees) {
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
