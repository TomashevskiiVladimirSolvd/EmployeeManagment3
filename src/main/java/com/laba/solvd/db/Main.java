package com.laba.solvd.db;

import com.laba.solvd.db.dao.*;
import com.laba.solvd.db.model.*;
import com.laba.solvd.db.service.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CredentialDAO credentialDAO = new CredentialDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        EmployeeTaskDAO employeeTaskDAO = new EmployeeTaskDAO();
        TaskDAO taskDAO = new TaskDAO();
        ProjectDAO projectDAO = new ProjectDAO();

        CredentialsServiceImpl credentialsService = new CredentialsServiceImpl(credentialDAO);
        EmployeesServiceImpl employeesService = new EmployeesServiceImpl(employeeDAO);
        EmployeeTaskServiceImpl employeeTaskService = new EmployeeTaskServiceImpl(employeeTaskDAO);
        TaskServiceImpl taskService = new TaskServiceImpl(taskDAO);
        ProjectServiceImpl projectService = new ProjectServiceImpl(projectDAO);

        Long credentialId = 1L;
        Credential credential = credentialsService.read(credentialId);
        System.out.println("Credential: " + credential);

        List<Employee> employees = employeesService.findAll();
        System.out.println("Employees: " + employees);


        List<EmployeeTask> employeeTasks = employeeTaskService.getAll();
        System.out.println("Employees Tasks: " + employeeTasks);

        Task task1 = new Task(1L, "Task 1", "High");
        taskService.create(task1);
        Task retrievedTask = taskService.read(1L);

        System.out.println("Retrieved Task:");
        System.out.println(retrievedTask);

        Project project1 = new Project(1L, "Project1");
        projectService.create(project1);
        Project retrievedProject = projectService.get(1L);
        System.out.println("Retrieved Project:");
        System.out.println(retrievedProject);

        credentialDAO.close();
        employeeDAO.close();
    }
}

