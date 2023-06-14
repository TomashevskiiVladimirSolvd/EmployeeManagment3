package com.laba.solvd.db;
import com.laba.solvd.db.dao.CredentialDAO;
import com.laba.solvd.db.dao.EmployeeDAO;
import com.laba.solvd.db.service.CredentialsServiceImpl;
import com.laba.solvd.db.service.EmployeesServiceImpl;
import com.laba.solvd.db.model.Employee;
import com.laba.solvd.db.model.Credential;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CredentialDAO credentialDAO = new CredentialDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        CredentialsServiceImpl credentialsService = new CredentialsServiceImpl(credentialDAO);
        EmployeesServiceImpl employeesService = new EmployeesServiceImpl(employeeDAO);

        Long credentialId = 1L;
        Credential credential = credentialsService.read(credentialId);
        System.out.println("Credential: " + credential);

        List<Employee> employees = employeesService.findAll();
        System.out.println("Employees: " + employees);

        credentialDAO.close();
        employeeDAO.close();
    }
}

