package com.laba.solvd.db.service;

import com.laba.solvd.db.Interfaces.CredentialsRepositoty;
import com.laba.solvd.db.dao.ConnectionPool;
import com.laba.solvd.db.model.Credentials;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class CredentialsServiceImpl implements CredentialsRepositoty {
    private static final ConnectionPool CONNECTION_POOL =ConnectionPool.getInstance();

    @Override
    public void create(Credentials credentials) {
        Connection connection= CONNECTION_POOL.getConnection();
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1,credentials.getId());
            preparedStatement.setString(2,credentials.getLogin());
            preparedStatement.setString(3,credentials.getPassword());

            preparedStatement.executeUpdate();
            ResultSet resultSet= preparedStatement.getGeneratedKeys();
        }catch(SQLException e){
           throw new RuntimeException("Unable to create credentials",e);
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
            }
        }

    }

    @Override
    public Optional<Credentials> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Credentials> findAll() {
        return null;
    }

    @Override
    public void update(Credentials credentials) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
