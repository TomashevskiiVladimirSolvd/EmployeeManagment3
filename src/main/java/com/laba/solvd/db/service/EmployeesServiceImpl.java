package com.laba.solvd.db.service;

import com.laba.solvd.db.dao.EmployeeDAO;


import com.laba.solvd.db.service.Interfaces.EmployeesRepository;
import com.laba.solvd.db.model.Employee;

import java.util.List;


public class EmployeesServiceImpl implements EmployeesRepository {
    private EmployeeDAO employeeDAO;

    public EmployeesServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.getAll();
    }
}


