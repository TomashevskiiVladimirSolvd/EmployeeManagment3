package com.laba.solvd.db.service;

import com.laba.solvd.db.dao.DepartmentRepositoryImpl;
import com.laba.solvd.db.dao.Interfaces.DepartmentRepository;
import com.laba.solvd.db.model.Department;
import com.laba.solvd.db.model.Employee;
import com.laba.solvd.db.service.Interfaces.DepartmentService;
import com.laba.solvd.db.service.Interfaces.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentsServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private EmployeeService employeeService;

    public DepartmentsServiceImpl() {
        this.departmentRepository = new DepartmentRepositoryImpl();
        this.employeeService = new EmployeesServiceImpl();
    }

    @Override
    public Department create(Department department) {
        department.setId(null);
        departmentRepository.create(department);

        if (department.getEmployees() != null) {
            List<Employee> employees = department.getEmployees().stream().
                    map(employee -> employeeService.create(employee, department.getId()))
                    .collect(Collectors.toList());
            department.setEmployees(employees);
        }

        return department;
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.getAll();
    }
}
