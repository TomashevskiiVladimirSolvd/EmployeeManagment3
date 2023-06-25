package com.laba.solvd.db.model;

import java.util.Objects;

public class EmployeeTask {
    private long id;
    private int percentageCompleted;

    private Task task;

    public EmployeeTask() {
    }

    public EmployeeTask(long id, int percentageCompleted) {
        this.id = id;
        this.percentageCompleted = percentageCompleted;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
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
        return id == that.id && percentageCompleted == that.percentageCompleted && Objects.equals(task, that.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, percentageCompleted, task);
    }

    @Override
    public String toString() {
        return "EmployeeTask{" +
                "id=" + id +
                ", percentageCompleted=" + percentageCompleted +
                ", task=" + task +
                '}';
    }
}
