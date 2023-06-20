package com.laba.solvd.db.service;

import com.laba.solvd.db.dao.ContactRepositoryImpl;
import com.laba.solvd.db.dao.CredentialRepositoryImpl;
import com.laba.solvd.db.dao.EmployeeRepositoryImpl;


import com.laba.solvd.db.dao.Interfaces.ContactRepository;
import com.laba.solvd.db.dao.Interfaces.CredentialRepository;
import com.laba.solvd.db.dao.Interfaces.EmployeeRepository;
import com.laba.solvd.db.model.Contact;
import com.laba.solvd.db.model.Credential;
import com.laba.solvd.db.service.Interfaces.ContactService;
import com.laba.solvd.db.service.Interfaces.CredentialService;
import com.laba.solvd.db.service.Interfaces.EmployeeService;
import com.laba.solvd.db.model.Employee;

import java.util.List;


public class EmployeesServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private CredentialService credentialService;
    private ContactService contactService;
    private ContactRepository contactRepository;
    private CredentialRepository credentialRepository;

    public EmployeesServiceImpl() {
        this.employeeRepository = new EmployeeRepositoryImpl();
        this.credentialService = new CredentialServiceImpl();
        this.contactService = new ContactServiceImpl();
        this.credentialRepository = new CredentialRepositoryImpl();
        this.contactRepository = new ContactRepositoryImpl();
    }


    @Override
    public Employee create(Employee employee) {
        employee.setId(null);
        employeeRepository.create(employee);
        if (employee.getCredentials() != null) {
            Credential credential = credentialService.create(employee.getCredentials());
            credentialRepository.setCredential(credential,employee);
        }
        if (employee.getContact() != null) {
            Contact contact = contactService.create(employee.getContact());
            contactRepository.setContact(contact,employee);
        }
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }
}


