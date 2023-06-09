package com.laba.solvd.db.model;

public class EmployeesSkills {
    private long id;
    private String proficiencyLevel;

    public EmployeesSkills(){};

    public EmployeesSkills(long id,String proficiencyLevel){
        this.id=id;
        this.proficiencyLevel=proficiencyLevel;
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
}
