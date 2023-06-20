package com.laba.solvd.db.model;

import java.util.Objects;

public class EmployeeTraining {
    private long id;
    private String status;

    private TrainingProgram trainingProgram;

    public EmployeeTraining() {
    }

    ;

    public EmployeeTraining(long id, String status) {
        this.id = id;
        this.status = status;
    }

    public TrainingProgram getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeTraining that = (EmployeeTraining) o;
        return id == that.id && Objects.equals(status, that.status) && Objects.equals(trainingProgram, that.trainingProgram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, trainingProgram);
    }

    @Override
    public String toString() {
        return "EmployeeTraining{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", trainingProgram=" + trainingProgram +
                '}';
    }
}
