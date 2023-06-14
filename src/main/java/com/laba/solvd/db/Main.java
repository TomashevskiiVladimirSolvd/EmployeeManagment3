package com.laba.solvd.db;

import com.laba.solvd.db.dao.CredentialDAO;
import com.laba.solvd.db.dao.EmployeeDAO;
import com.laba.solvd.db.dao.EmployeeTaskDAO;
import com.laba.solvd.db.dao.TaskDAO;
import com.laba.solvd.db.model.EmployeeTask;
import com.laba.solvd.db.service.CredentialsServiceImpl;
import com.laba.solvd.db.service.EmployeeTaskServiceImpl;
import com.laba.solvd.db.service.EmployeesServiceImpl;
import com.laba.solvd.db.service.TaskServiceImpl;
import com.laba.solvd.db.model.Employee;
import com.laba.solvd.db.model.Credential;
import com.laba.solvd.db.model.Task;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CredentialDAO credentialDAO = new CredentialDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        EmployeeTaskDAO employeeTaskDAO = new EmployeeTaskDAO();
        TaskDAO taskDAO = new TaskDAO();

        CredentialsServiceImpl credentialsService = new CredentialsServiceImpl(credentialDAO);
        EmployeesServiceImpl employeesService = new EmployeesServiceImpl(employeeDAO);
        EmployeeTaskServiceImpl employeeTaskService = new EmployeeTaskServiceImpl(employeeTaskDAO);
        TaskServiceImpl taskService = new TaskServiceImpl(taskDAO);

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

        credentialDAO.close();
        employeeDAO.close();
    }
}

