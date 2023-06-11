package com.laba.solvd.db.service;

import com.laba.solvd.db.Interfaces.EmployeesRepository;
import com.laba.solvd.db.dao.ConnectionPool;
import com.laba.solvd.db.model.Credentials;
import com.laba.solvd.db.model.Employees;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeesServiceImpl implements EmployeesRepository {
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public Employees create(Employees employees) {
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Employees(id, name, position) VALUES (?, ?, ?)");

            preparedStatement.setLong(1, employees.getId());
            preparedStatement.setString(2, employees.getName());
            preparedStatement.setString(3, employees.getPosition());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                long generatedId = resultSet.getLong(1);
                employees.setId(generatedId);
            }

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
            List<Employees> employeesList = new ArrayList<>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");

                Employees employees = new Employees(id, name, position);
                employeesList.add(employees);
            }

            return employeesList;
        } catch (SQLException e) {
            throw new RuntimeException("Unable to fetch all employees", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}

