package com.laba.solvd.db.service.Interfaces;

import com.laba.solvd.db.model.Credential;

import java.util.List;
import java.util.Optional;

public interface CredentialsRepository {

    List<Credential> findAll();

    void update(Credential credential);

}
