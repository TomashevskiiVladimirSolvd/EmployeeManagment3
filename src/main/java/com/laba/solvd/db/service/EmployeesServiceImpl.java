package com.laba.solvd.db.service;

import com.laba.solvd.db.dao.Interfaces.ContactRepository;
import com.laba.solvd.db.dao.Interfaces.CredentialRepository;
import com.laba.solvd.db.dao.Interfaces.DAOFactory;
import com.laba.solvd.db.dao.Interfaces.EmployeeRepository;
import com.laba.solvd.db.model.Contact;
import com.laba.solvd.db.model.Credential;
import com.laba.solvd.db.model.Employee;
import com.laba.solvd.db.service.Interfaces.ContactService;
import com.laba.solvd.db.service.Interfaces.CredentialService;
import com.laba.solvd.db.service.Interfaces.EmployeeService;

import java.util.List;


public class EmployeesServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CredentialService credentialService;
    private final ContactService contactService;
    private final ContactRepository contactRepository;
    private final CredentialRepository credentialRepository;

    public EmployeesServiceImpl(DAOFactory daoFactory) {
        this.employeeRepository = daoFactory.createEmployeeRepository();
        this.credentialService = new CredentialServiceImpl(daoFactory);
        this.contactService = new ContactServiceImpl(daoFactory);
        this.credentialRepository = daoFactory.createCredentialRepository();
        this.contactRepository = daoFactory.createContactRepository();
    }

    @Override
    public Employee create(Employee employee) {
        employee.setId(null);
        employeeRepository.create(employee);

        if (employee.getCredentials() != null) {
            Credential credential = credentialService.create(employee.getCredentials());
            credentialRepository.setCredential(credential, employee);
        }

        if (employee.getContact() != null) {
            Contact contact = contactService.create(employee.getContact());
            contactRepository.setContact(contact, employee);
        }

        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }
}



