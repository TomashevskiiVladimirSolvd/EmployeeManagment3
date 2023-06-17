package com.laba.solvd.db.service.Interfaces;

import com.laba.solvd.db.model.Credential;

import java.util.List;

public interface CredentialsService {

    void create(Credential credential);

    List<Credential> getAll();

}
