package com.laba.solvd.db.service.Interfaces;

import com.laba.solvd.db.model.Contact;

import java.util.List;

public interface ContactService {
    Contact create(Contact contact);

    List<Contact> getAll();
}
