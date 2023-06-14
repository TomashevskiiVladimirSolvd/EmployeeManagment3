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


public class EmployeesServiceImpl implements EmployeesRepository {


    public EmployeesServiceImpl() {


    }


    @Override
    public Employee create(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }
}

