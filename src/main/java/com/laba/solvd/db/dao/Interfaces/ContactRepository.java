package com.laba.solvd.db.dao.Interfaces;

import com.laba.solvd.db.model.Contact;

import java.util.List;

public interface ContactRepository {
    void create(Contact contact);

    List<Contact> getAll();
}
