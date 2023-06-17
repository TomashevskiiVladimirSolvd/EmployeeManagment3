package com.laba.solvd.db.service;

import com.laba.solvd.db.dao.ContactRepositoryImpl;
import com.laba.solvd.db.dao.Interfaces.ContactRepository;
import com.laba.solvd.db.model.Contact;
import com.laba.solvd.db.service.Interfaces.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;

    public ContactServiceImpl(){
        this.contactRepository= new ContactRepositoryImpl();
    }
    @Override
    public Contact create(Contact contact) {
        contact.setId(null);
        contactRepository.create(contact);
        return contact;
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.getAll();
    }
}
