package com.laba.solvd.db.dao;

import com.laba.solvd.db.dao.Interfaces.CredentialRepository;
import com.laba.solvd.db.model.Credential;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CredentialRepositoryImpl implements CredentialRepository {
    Logger log = Logger.getLogger(CredentialRepositoryImpl.class.getName());
    private static final ConnectionPool CONNECTIONPOOL = ConnectionPool.getInstance();
    private String sqlEmpCr = "SELECT e.id,e.name,e.position,cr.login,cr.password FROM employees e INNER JOIN credentials cr ON e.id = cr.employee_id;";


    @Override
    public void create(Credential credential) {
        Connection connection = CONNECTIONPOOL.getConnection();
        try {
            String sql = "INSERT INTO Credentials (id, login, password) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, credential.getId());
            statement.setString(2, credential.getLogin());
            statement.setString(3, credential.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Credential> getAll() {
        return null;
    }


    public void close() {
        Connection connection = CONNECTIONPOOL.getConnection();
        CONNECTIONPOOL.releaseConnection(connection);
    }

}
