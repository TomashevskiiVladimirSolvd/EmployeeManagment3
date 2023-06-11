package com.laba.solvd.db.model;

import java.util.Objects;

public class EmployeesSkills {
    private long id;
    private String proficiencyLevel;
    private Employees employee;
    private Skills skills;

    public EmployeesSkills(){};

    public EmployeesSkills(long id,String proficiencyLevel){
        this.id=id;
        this.proficiencyLevel=proficiencyLevel;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
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

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesSkills that = (EmployeesSkills) o;
        return id == that.id && Objects.equals(proficiencyLevel, that.proficiencyLevel) && Objects.equals(employee, that.employee) && Objects.equals(skills, that.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, proficiencyLevel, employee, skills);
    }
}
