package com.laba.solvd.db.model;

import java.util.List;
import java.util.Objects;

public class Skill {
    private long id;
    private String name;
    private List<EmployeeSkill> employees;

    public Skill() {
    }

    ;

    public Skill(long id, String name,List<EmployeeSkill> employees) {
        this.id = id;
        this.name = name;
        this.employees=employees;
    }

    public List<EmployeeSkill> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeSkill> employees) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return id == skill.id && Objects.equals(name, skill.name) && Objects.equals(employees, skill.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employees);
    }
}
