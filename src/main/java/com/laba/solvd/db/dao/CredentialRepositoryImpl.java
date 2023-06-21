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
    private final String sqlAll = "SELECT c.id as credential_id,c.login as credential_login,c.password as credential_password  FROM credentials c";


    @Override
    public void create(Credential credential) {
        Connection connection = CONNECTIONPOOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Credentials ( login, password) VALUES ( ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, credential.getLogin());
            preparedStatement.setString(2, credential.getPassword());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                credential.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            log.info("Unable to create credentials", e);
        } finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
    }

    @Override
    public List<Credential> getAll() {
        Connection connection = CONNECTIONPOOL.getConnection();
        List<Credential> credentialList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlAll);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Credential credential = new Credential();
                credential.setId(resultSet.getLong("credential_id"));
                credential.setPassword(resultSet.getString("credential_password"));
                credential.setLogin(resultSet.getString("credential_login"));
                credentialList.add(credential);
            }
        } catch (SQLException e) {
            log.info("Error executing SQL statement", e);
        } finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
        return credentialList;
    }

    @Override
    public void setCredential(Credential credential, Employee employee) {
        Connection connection = null;
        String sql = "INSERT INTO credentials (id,employee_id) VALUES(?,?) ";
        try {
            connection = CONNECTIONPOOL.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, credential.getId());
            statement.setLong(2, employee.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            log.info("Failed to connect", e);
        } finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
    }

    public static void mapRow(ResultSet resultSet, List<Credential> credentials) throws SQLException {
        credentials.add(mapRow(resultSet));
    }

    public static Credential mapRow(ResultSet resultSet) throws SQLException {
        Credential credential = null;

        long id = resultSet.getLong("credential_id");
        if (id != 0) {
            credential = new Credential();
            credential.setId(resultSet.getLong("credential_id"));
            credential.setLogin(resultSet.getString("credential_login"));
            credential.setPassword(resultSet.getString("credential_password"));
        }

        return credential;
    }
}
