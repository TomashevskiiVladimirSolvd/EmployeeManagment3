package com.laba.solvd.db.dao.Interfaces;

import com.laba.solvd.db.model.Department;

import java.util.List;

public interface DepartmentRepository {
    void create(Department department);

    List<Department> getAll();
}
