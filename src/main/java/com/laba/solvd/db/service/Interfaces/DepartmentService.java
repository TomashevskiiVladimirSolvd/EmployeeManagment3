package com.laba.solvd.db.service.Interfaces;

import com.laba.solvd.db.model.Department;

import java.util.List;

public interface DepartmentService {
    Department create(Department department);

    List<Department> getAll();
}
