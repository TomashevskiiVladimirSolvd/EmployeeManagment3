package com.laba.solvd.db.service;

import com.laba.solvd.db.dao.CredentialRepositoryImpl;
import com.laba.solvd.db.dao.Interfaces.CredentialRepository;
import com.laba.solvd.db.model.Credential;
import com.laba.solvd.db.service.Interfaces.CredentialService;

import java.util.List;


public class CredentialServiceImpl implements CredentialService {
    private final CredentialRepository credentialRepository;

    public CredentialServiceImpl() {
        this.credentialRepository = new CredentialRepositoryImpl();
        // this.credentialRepository=new CredentialMapperImpl();
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

