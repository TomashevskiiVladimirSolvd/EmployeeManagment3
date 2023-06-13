package com.laba.solvd.db.model;

import java.util.Objects;

public class EmployeeTask {
    private long id;
    private int percentageCompleted;

    public EmployeeTask() {
    }

    ;

    public EmployeeTask(long id, int percentageCompleted) {
        this.id = id;
        this.percentageCompleted = percentageCompleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPercentageCompleted() {
        return percentageCompleted;
    }

    public void setPercentageCompleted(int percentageCompleted) {
        this.percentageCompleted = percentageCompleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeTask that = (EmployeeTask) o;
        return id == that.id && percentageCompleted == that.percentageCompleted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, percentageCompleted);
    }
}
