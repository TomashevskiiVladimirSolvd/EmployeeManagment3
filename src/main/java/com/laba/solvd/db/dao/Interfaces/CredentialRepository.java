package com.laba.solvd.db.dao.Interfaces;

import com.laba.solvd.db.model.Credential;

import java.util.List;

public interface CredentialRepository {
    void create(Credential credential);

    List<Credential> getAll();
}
