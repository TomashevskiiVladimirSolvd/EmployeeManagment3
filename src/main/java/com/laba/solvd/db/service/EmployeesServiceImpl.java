package com.laba.solvd.db.service;

import com.laba.solvd.db.Interfaces.CredentialsRepositoty;
import com.laba.solvd.db.Interfaces.EmployeesRepository;
import com.laba.solvd.db.model.Credentials;
import com.laba.solvd.db.model.Employees;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeesServiceImpl implements EmployeesRepository {
    private final EmployeesRepository employeesRepository;
    private final CredentialsServiceImpl credentialsService;

    public EmployeesServiceImpl() {
        this.employeesRepository = new EmployeesServiceImpl();
        this.credentialsService = new CredentialsServiceImpl();
    }

    @Override
    public Employees create(Employees employees) {
        return employees;
    }
}

