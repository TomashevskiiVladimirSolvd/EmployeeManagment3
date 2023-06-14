package com.laba.solvd.db.model;

import java.util.List;
import java.util.Objects;

public class TrainingPrograms {
    private long id;
    private String name;
    private List<EmployeeTraining> employees;

    public TrainingPrograms() {
    }

    ;

    public TrainingPrograms(long id, String name,List<EmployeeTraining> employees) {
        this.id = id;
        this.name = name;
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

    public List<EmployeeTraining> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeTraining> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingPrograms that = (TrainingPrograms) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employees);
    }
}
