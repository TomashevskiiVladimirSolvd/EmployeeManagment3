package com.laba.solvd.db.service;

import com.laba.solvd.db.model.Credentials;
import com.laba.solvd.db.model.Employees;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Credentials credentials =new Credentials();
        credentials.setId(1);
        credentials.setLogin("log1");
        credentials.setPassword("12345");

        Employees employees=new Employees();
        employees.setId(1);
        employees.setName("Ivan Petrov");
        employees.setPosition("Top manager");
        employees.setCredentials(credentials);

        EmployeesServiceImpl employeesService= new EmployeesServiceImpl();
        employees=employeesService.create(employees);

        List<Employees> empl= employeesService.findAll();
        System.out.println(employees);



    }
}
