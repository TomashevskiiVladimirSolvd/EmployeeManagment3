package com.laba.solvd.db.service;

import com.laba.solvd.db.dao.EmployeeRepositoryImpl;


import com.laba.solvd.db.service.Interfaces.EmployeeService;
import com.laba.solvd.db.model.Employee;

import java.util.List;


public class EmployeesServiceImpl implements EmployeeService {
    private EmployeeRepositoryImpl employeeRepository;
    private CredentialsServiceImpl credentialService;

    public EmployeesServiceImpl() {
        this.employeeRepository = new EmployeeRepositoryImpl();
        this.credentialService = new CredentialsServiceImpl();
    }


    @Override
    public Employee create(Employee employee) {
        employee.setId(null);
        employeeRepository.create(employee);

        if (employee.getCredentials() != null) {

        }
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }
}


