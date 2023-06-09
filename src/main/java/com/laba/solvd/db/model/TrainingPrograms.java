package com.laba.solvd.db.model;

public class TrainingPrograms {
    private long id;
    private String name;

    public TrainingPrograms(){};

    public TrainingPrograms(long id,String name){
        this.id=id;
        this.name=name;
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
