package com.laba.solvd.db.service;

import com.laba.solvd.db.dao.CredentialRepositoryImpl;
import com.laba.solvd.db.dao.Interfaces.CredentialRepository;
import com.laba.solvd.db.service.Interfaces.CredentialsService;
import com.laba.solvd.db.model.Credential;

import java.util.List;


public class CredentialsServiceImpl implements CredentialsService {
    private CredentialRepository credentialRepository;

    public CredentialsServiceImpl(CredentialRepositoryImpl credentialRepositoryImpl) {
        this.credentialRepository = credentialRepositoryImpl;
    }


    @Override
    public Credential create(Credential credential) {
        credential.setId(null);
        credentialRepository.create(credential);
        return credential;
    }

    @Override
    public List<Credential> getAll() {
        return credentialRepository.getAll();
    }
}

