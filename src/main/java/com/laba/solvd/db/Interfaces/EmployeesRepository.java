package com.laba.solvd.db.Interfaces;

import com.laba.solvd.db.model.Employees;

import java.util.List;

public interface EmployeesRepository {
    void create(Employees employees);
    List<Employees> findAll();
}
