package com.laba.solvd.db.service;

import com.laba.solvd.db.Interfaces.EmployeesRepository;
import com.laba.solvd.db.dao.ConnectionPool;
import com.laba.solvd.db.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeesServiceImpl implements EmployeesRepository {
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public Employee create(Employee employee) {
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Employees(id, name, position) VALUES (?, ?, ?)");

            preparedStatement.setLong(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getPosition());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                long generatedId = resultSet.getLong(1);
                employee.setId(generatedId);
            }

            return employee;
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create employees", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public List<Employee> findAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Employees");

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Employee> employeeList = new ArrayList<>();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");

                Employee employee = new Employee(id, name, position);
                employeeList.add(employee);
            }

            return employeeList;
        } catch (SQLException e) {
            throw new RuntimeException("Unable to fetch all employees", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}

