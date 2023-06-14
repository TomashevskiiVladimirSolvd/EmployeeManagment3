package com.laba.solvd.db.service;

import com.laba.solvd.db.service.Interfaces.CredentialsRepository;
import com.laba.solvd.db.dao.ConnectionPool;
import com.laba.solvd.db.model.Credential;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CredentialsServiceImpl implements CredentialsRepository {

    public CredentialsServiceImpl(){

    }

    @Override
    public void create(Credential credential) {

    }

    @Override
    public Optional<Credential> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Credential> findAll() {
        return null;
    }

    @Override
    public void update(Credential credential) {

    }

    @Override
    public void deleteById(Long id) {

    }
}

