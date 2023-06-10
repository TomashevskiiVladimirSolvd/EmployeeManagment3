package com.laba.solvd.db.model;

public class EmployeesTasks {
    private long id;
    private int percentageCompleted;
    private Employees employee;
    private Tasks tasks;
    public EmployeesTasks(){};

    public EmployeesTasks(long id,int percentageCompleted){
        this.id=id;
        this.percentageCompleted=percentageCompleted;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
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

    public int getPercentageCompleted() {
        return percentageCompleted;
    }

    public void setPercentageCompleted(int percentageCompleted) {
        this.percentageCompleted = percentageCompleted;
    }
}
