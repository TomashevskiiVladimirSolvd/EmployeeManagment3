package com.laba.solvd.db.dao.Interfaces;

import com.laba.solvd.db.model.Contact;
import com.laba.solvd.db.model.Credential;
import com.laba.solvd.db.model.Employee;

import java.util.List;

public interface ContactRepository {
    void create(Contact contact);

    List<Contact> getAll();

    void setContact(Contact contact, Employee employee);
}
