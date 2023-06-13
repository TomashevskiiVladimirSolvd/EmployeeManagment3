package com.laba.solvd.db.model;

import java.util.Objects;

public class EmployeeSkill {
    private long id;
    private String proficiencyLevel;

    public EmployeeSkill() {
    }

    ;

    public EmployeeSkill(long id, String proficiencyLevel) {
        this.id = id;
        this.proficiencyLevel = proficiencyLevel;
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
        EmployeeSkill that = (EmployeeSkill) o;
        return id == that.id && Objects.equals(proficiencyLevel, that.proficiencyLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, proficiencyLevel);
    }
}
