package com.laba.solvd.db.service;

import com.laba.solvd.db.dao.CredentialRepositoryImpl;
import com.laba.solvd.db.service.Interfaces.CredentialsService;
import com.laba.solvd.db.model.Credential;

import java.util.List;


public class CredentialsServiceImpl implements CredentialsService {
    private CredentialRepositoryImpl credentialRepositoryImpl;

    public CredentialsServiceImpl(CredentialRepositoryImpl credentialRepositoryImpl) {
        this.credentialRepositoryImpl = credentialRepositoryImpl;
    }


    @Override
    public void create(Credential credential) {

    }

    @Override
    public List<Credential> getAll() {
        return null;
    }
}

