package com.laba.solvd.db.model;

public class EmployeesTasks {
    private long id;
    private int percentageCompleted;
    public EmployeesTasks(){};

    public EmployeesTasks(long id,int percentageCompleted){
        this.id=id;
        this.percentageCompleted=percentageCompleted;
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
