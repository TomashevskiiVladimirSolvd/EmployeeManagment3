package com.laba.solvd.db.service.Interfaces;

import com.laba.solvd.db.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee create(Employee employee);

    ;

    List<Employee> getAll();

}
