package com.laba.solvd.db.service;

import com.laba.solvd.db.Interfaces.EmployeesRepository;
import com.laba.solvd.db.dao.ConnectionPool;
import com.laba.solvd.db.model.Credentials;
import com.laba.solvd.db.model.Employees;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeesServiceImpl implements EmployeesRepository {

    private static final ConnectionPool CONNECTION_POOL =ConnectionPool.getInstance();

    @Override
    public Employees create(Employees employees) {
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into Employees(id,name,position)values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, employees.getId());
            preparedStatement.setString(2, employees.getName());
            preparedStatement.setString(3, employees.getPosition());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create employees", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public List<Employees> findAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Employees");

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Employees> employeesLists = new ArrayList<>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");

                Employees employees = new Employees(id, name, position);
                employeesLists.add(employees);
            }

            return employeesLists;
        } catch (SQLException e) {
            throw new RuntimeException("Unable to fetch all employees", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}

