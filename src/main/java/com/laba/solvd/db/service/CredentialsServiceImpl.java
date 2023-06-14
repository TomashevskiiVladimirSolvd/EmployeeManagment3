package com.laba.solvd.db.service;

import com.laba.solvd.db.dao.CredentialDAO;
import com.laba.solvd.db.service.Interfaces.CredentialsRepository;
import com.laba.solvd.db.model.Credential;


public class CredentialsServiceImpl implements CredentialsRepository {
    private CredentialDAO credentialDAO;

    public CredentialsServiceImpl(CredentialDAO credentialDAO) {
        this.credentialDAO = credentialDAO;
    }

    @Override
    public Credential read(Long id) {
        return credentialDAO.read(id);
    }


}

