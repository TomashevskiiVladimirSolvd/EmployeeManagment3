package com.laba.solvd.db.domain;

import java.util.List;

public class Projects {
    private long id;
    private String name;
    private List<Tasks> tasks;

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
