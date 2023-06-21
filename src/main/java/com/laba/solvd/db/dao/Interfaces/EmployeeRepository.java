package com.laba.solvd.db.dao.Interfaces;

import com.laba.solvd.db.model.Department;
import com.laba.solvd.db.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    void create(Employee employee);

    List<Employee> getAll();

    void setEmployee(Employee employee, Department department);

}
