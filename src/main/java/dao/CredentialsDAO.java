package dao;

import Interfaces.IDao;

import model.*;

import java.sql.*;

import java.util.List;

public class CredentialsDAO implements IDao<Credentials, Long> {
    private Connection connection;

    public CredentialsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Credentials entity) {
    }

    @Override
    public Credentials read(Long id) {
        return null;
    }

    @Override
    public void update(Credentials entity) {
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public List<Credentials> getAll() {
        return null;
    }
}

