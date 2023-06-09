package com.laba.solvd.db.domain;

import java.util.List;

public class Tasks {
    private long id;
    private String name;
    private String priority;
    private List<EmployeesTasks> tasks;

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
