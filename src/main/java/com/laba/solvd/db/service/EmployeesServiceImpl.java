package com.laba.solvd.db.service;

import com.laba.solvd.db.dao.EmployeeDAO;
import com.laba.solvd.db.dao.Interfaces.IDAOCredential;
import com.laba.solvd.db.dao.Interfaces.IDao;
import com.laba.solvd.db.model.Skill;
import com.laba.solvd.db.service.Interfaces.CredentialsRepository;
import com.laba.solvd.db.service.Interfaces.EmployeesRepository;
import com.laba.solvd.db.dao.ConnectionPool;
import com.laba.solvd.db.model.Employee;
import jdk.jfr.internal.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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


