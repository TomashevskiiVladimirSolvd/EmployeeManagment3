package com.laba.solvd.db.service.Interfaces;

import com.laba.solvd.db.model.Employee;

import java.util.List;

public interface EmployeesRepository {

    List<Employee> findAll();

}
