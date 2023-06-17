package com.laba.solvd.db.dao;

import com.laba.solvd.db.dao.Interfaces.CredentialRepository;
import com.laba.solvd.db.model.Credential;
import com.laba.solvd.db.model.Employee;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CredentialRepositoryImpl implements CredentialRepository {
    Logger log = Logger.getLogger(CredentialRepositoryImpl.class.getName());
    private static final ConnectionPool CONNECTIONPOOL = ConnectionPool.getInstance();
    private String sqlEmpCr = "SELECT * FROM credentials";


    @Override
    public void create(Credential credential) {
        Connection connection = CONNECTIONPOOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Credentials ( login, password) VALUES ( ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, credential.getLogin());
            preparedStatement.setString(2, credential.getPassword());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                credential.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            log.info("Unable to create credentials", e);
        }finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
    }

    @Override
    public List<Credential> getAll() {
        Connection connection = CONNECTIONPOOL.getConnection();
        List<Credential> credentialList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlEmpCr);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Credential credential = new Credential();
                credential.setId(resultSet.getLong("id"));
                credential.setPassword(resultSet.getString("password"));
                credential.setLogin(resultSet.getString("login"));
                credentialList.add(credential);
            }
        } catch (SQLException e) {
            log.info("Error executing SQL statement", e);
        } finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
        return credentialList;
    }



}
