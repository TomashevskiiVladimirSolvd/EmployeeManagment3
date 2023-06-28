package com.laba.solvd.db;

import com.laba.solvd.db.dao.Interfaces.DAOFactory;
import com.laba.solvd.db.model.Contact;
import com.laba.solvd.db.model.Credential;
import com.laba.solvd.db.model.Department;
import com.laba.solvd.db.model.Employee;
import com.laba.solvd.db.service.DepartmentsServiceImpl;
import com.laba.solvd.db.service.Interfaces.DepartmentService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOFactory daoFactory = new MyBatisDAOFactory();

        Credential credential1 = new Credential();
        credential1.setLogin("log1");
        credential1.setPassword("0987");

        Contact contact1 = new Contact();
        contact1.setEmail("john.doe@example.com");
        contact1.setPhone("1234567890");

        Employee employee1 = new Employee();
        employee1.setName("Joe Jonson");
        employee1.setPosition("Manager");
        employee1.setCredential(credential1);
        employee1.setContact(contact1);

        Credential credential2 = new Credential();
        credential2.setLogin("log2");
        credential2.setPassword("1038");

        Contact contact2 = new Contact();
        contact2.setEmail("jane.smith@example.com");
        contact2.setPhone("9876543210");

        Employee employee2 = new Employee();
        employee2.setName("Bob Tornton");
        employee2.setPosition("Senior Manager");
        employee2.setCredential(credential2);
        employee2.setContact(contact2);

        Department department = new Department();
        department.setName("Sales");
        department.setEmployees(Arrays.asList(employee1, employee2));

        DepartmentService departmentService = new DepartmentsServiceImpl(daoFactory);
        department = departmentService.create(department);

        System.out.println(department);

        List<Department> allDepartments = departmentService.getAll();
        System.out.println(allDepartments);
    }
}


