package com.laba.solvd.db.service;

import com.laba.solvd.db.model.Credentials;
import com.laba.solvd.db.model.Employees;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        CredentialsServiceImpl credentialsService = new CredentialsServiceImpl();

        Credentials credentials = new Credentials();
        credentials.setId(1);
        credentials.setLogin("john.doe");
        credentials.setPassword("password");

        credentialsService.create(credentials);

        long credentialsId = 1;
        Optional<Credentials> foundCredentials = credentialsService.findById(credentialsId);
        foundCredentials.ifPresent(c -> System.out.println("Found credentials: " + c));

        Credentials credentialsToUpdate = foundCredentials.orElseThrow(() -> new RuntimeException("Credentials not found"));
        credentialsToUpdate.setLogin("newlogin");
        credentialsToUpdate.setPassword("newpassword");

        credentialsService.update(credentialsToUpdate);

        long credentialsIdToDelete = 1;
        credentialsService.deleteById(credentialsIdToDelete);


        EmployeesServiceImpl employeesService = new EmployeesServiceImpl();
        Employees employee = new Employees();
        employee.setId(1);
        employee.setName("John Doe");
        employee.setPosition("Manager");
        employee.setCredentials(credentials);

        Employees createdEmployee = employeesService.create(employee);
        System.out.println("Employee created: " + createdEmployee);

        List<Employees> allEmployees = employeesService.findAll();
        System.out.println("All Employees:");
        for (Employees emp : allEmployees) {
            System.out.println(emp);
        }



    }
}
