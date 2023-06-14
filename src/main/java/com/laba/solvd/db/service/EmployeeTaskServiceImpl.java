package com.laba.solvd.db.service;

import com.laba.solvd.db.dao.EmployeeTaskDAO;
import com.laba.solvd.db.model.EmployeeTask;
import com.laba.solvd.db.service.Interfaces.EmployeeTaskRepository;

import java.util.List;

public class EmployeeTaskServiceImpl implements EmployeeTaskRepository {
    private EmployeeTaskDAO employeeTaskDAO;

    public EmployeeTaskServiceImpl(EmployeeTaskDAO employeeTaskDAO) {
        this.employeeTaskDAO = employeeTaskDAO;
    }

    @Override
    public List<EmployeeTask> getAll() {
        return employeeTaskDAO.getAll();
    }
}
