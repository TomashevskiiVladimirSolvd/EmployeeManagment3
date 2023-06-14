package com.laba.solvd.db.model;

import java.util.List;
import java.util.Objects;

public class Task {
    private long id;
    private String name;
    private String priority;
    private List<EmployeeTask> employees;

    public Task() {
    }

    ;

    public Task(long id, String name, String priority,List<EmployeeTask> employees) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.employees=employees;
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

    public List<EmployeeTask> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeTask> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(name, task.name) && Objects.equals(priority, task.priority) && Objects.equals(employees, task.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, priority, employees);
    }
}
