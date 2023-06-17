package com.laba.solvd.db.model;

import java.util.List;
import java.util.Objects;

public class TrainingPrograms {
    private long id;
    private String name;

    public TrainingPrograms() {
    }

    ;

    public TrainingPrograms(long id, String name, List<EmployeeTraining> employees) {
        this.id = id;
        this.name = name;
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
        TrainingPrograms that = (TrainingPrograms) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
