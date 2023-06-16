package com.laba.solvd.db.service.Interfaces;

import com.laba.solvd.db.model.Employee;

import java.util.List;

public interface EmployeesRepository {

    Employee create(Employee employee);

    List<Employee> getAll();

}
