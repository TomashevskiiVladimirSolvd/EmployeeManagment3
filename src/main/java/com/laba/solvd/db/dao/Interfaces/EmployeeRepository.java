package com.laba.solvd.db.dao.Interfaces;

import com.laba.solvd.db.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    void create(Employee employee, Long departmentId);

    List<Employee> getAll();

}
