package com.laba.solvd.db.Interfaces;

import com.laba.solvd.db.model.Employees;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeesRepository {
    Employees create(Employees employees);

}
