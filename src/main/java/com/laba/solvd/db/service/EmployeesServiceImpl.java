package com.laba.solvd.db.service;

import com.laba.solvd.db.domain.Employees;

public class EmployeesServiceImpl implements EmployeeService {

    public EmployeesServiceImpl(){

    }

    @Override
    public Employees create(Employees employees) {
        return employees;
    }
}
