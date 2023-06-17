package com.laba.solvd.db.service;

import com.laba.solvd.db.dao.EmployeeRepositoryImpl;


import com.laba.solvd.db.dao.Interfaces.EmployeeRepository;
import com.laba.solvd.db.model.Credential;
import com.laba.solvd.db.service.Interfaces.CredentialService;
import com.laba.solvd.db.service.Interfaces.EmployeeService;
import com.laba.solvd.db.model.Employee;

import java.util.List;


public class EmployeesServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private CredentialService credentialService;

    public EmployeesServiceImpl() {
        this.employeeRepository =new EmployeeRepositoryImpl();
        this.credentialService = new CredentialServiceImpl();
    }


    @Override
    public Employee create(Employee employee,Long departmentId) {
        employee.setId(null);
        if(employee.getCredentials()!=null){
            Credential credential =credentialService.create(employee.getCredentials());
            employee.setCredentials(credential);
        }
        employeeRepository.create(employee,departmentId);

        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }
}


