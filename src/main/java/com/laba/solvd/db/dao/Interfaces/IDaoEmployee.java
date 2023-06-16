package com.laba.solvd.db.dao.Interfaces;

import com.laba.solvd.db.model.Employee;

import java.util.List;

public interface IDaoEmployee {

    void create(Employee employee);

    List<Employee> getAll();

}
