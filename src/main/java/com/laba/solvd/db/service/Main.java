package com.laba.solvd.db.service;

import com.laba.solvd.db.model.Credentials;
import com.laba.solvd.db.model.Employees;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeesServiceImpl employeesService = new EmployeesServiceImpl();
        Employees employee = new Employees();
        employee.setId(1);
        employee.setName("John Doe");
        employee.setPosition("Manager");

        Employees createdEmployee = employeesService.create(employee);
        System.out.println("Employee created: " + createdEmployee);

        List<Employees> allEmployees = employeesService.findAll();
        System.out.println("All Employees:");
        for (Employees emp : allEmployees) {
            System.out.println(emp);
        }



    }
}
