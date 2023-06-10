package com.laba.solvd.db.model;

public class EmployeesTrainings {
    private long id;
    private String status;
    private Employees employee;
    private  TrainingPrograms trainingPrograms;
    public EmployeesTrainings(){};

    public EmployeesTrainings(long id,String status){
        this.id=id;
        this.status=status;
    }

    public TrainingPrograms getTrainingPrograms() {
        return trainingPrograms;
    }

    public void setTrainingPrograms(TrainingPrograms trainingPrograms) {
        this.trainingPrograms = trainingPrograms;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
