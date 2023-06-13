package com.laba.solvd.db.dao.Interfaces;

import com.laba.solvd.db.model.EmployeeTask;

import java.util.List;

public interface IDAOEmployeeTask {
    void create(EmployeeTask employeeTask);

    void update(EmployeeTask employeeTask);

    List<EmployeeTask> getAll();
}
