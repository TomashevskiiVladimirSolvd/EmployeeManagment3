package com.laba.solvd.db;

import com.laba.solvd.db.model.Credential;
import com.laba.solvd.db.model.Employee;
import com.laba.solvd.db.service.CredentialsServiceImpl;
import com.laba.solvd.db.service.EmployeesServiceImpl;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        CredentialsServiceImpl credentialsService = new CredentialsServiceImpl();

        Credential credential = new Credential();
        credential.setId(1);
        credential.setLogin("john.doe");
        credential.setPassword("password");

        credentialsService.create(credential);

        long credentialsId = 1;
        Optional<Credential> foundCredentials = credentialsService.findById(credentialsId);
        foundCredentials.ifPresent(c -> System.out.println("Found credentials: " + c));

        Credential credentialToUpdate = foundCredentials.orElseThrow(() -> new RuntimeException("Credentials not found"));
        credentialToUpdate.setLogin("newlogin");
        credentialToUpdate.setPassword("newpassword");

        credentialsService.update(credentialToUpdate);

        long credentialsIdToDelete = 1;
        credentialsService.deleteById(credentialsIdToDelete);


        EmployeesServiceImpl employeesService = new EmployeesServiceImpl();
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John Doe");
        employee.setPosition("Manager");
        employee.setCredentials(credential);

        Employee createdEmployee = employeesService.create(employee);
        System.out.println("Employee created: " + createdEmployee);

        List<Employee> allEmployees = employeesService.findAll();
        System.out.println("All Employees:");
        for (Employee emp : allEmployees) {
            System.out.println(emp);
        }


    }
}
