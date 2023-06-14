package com.laba.solvd.db.service.Interfaces;

import com.laba.solvd.db.model.EmployeeTask;

import java.util.List;

public interface EmployeeTaskRepository {
    public List<EmployeeTask> getAll();
}
