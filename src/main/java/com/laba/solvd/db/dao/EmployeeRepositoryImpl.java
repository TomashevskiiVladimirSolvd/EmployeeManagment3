package com.laba.solvd.db.dao;

import com.laba.solvd.db.dao.Interfaces.EmployeeRepository;
import com.laba.solvd.db.model.Employee;
import org.apache.log4j.Logger;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final Logger log = Logger.getLogger(EmployeeRepositoryImpl.class.getName());
    private static final ConnectionPool CONNECTIONPOOL = ConnectionPool.getInstance();
    private final String sqlAll = "SELECT * FROM employees e";

    @Override
    public void create(Employee employee) {
        Connection connection = CONNECTIONPOOL.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Employees (name, position) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getPosition());
            preparedStatement.executeUpdate();

            ResultSet ResultSet = preparedStatement.getGeneratedKeys();
            while (ResultSet.next()) {
                employee.setId(ResultSet.getLong("id"));
            }
        } catch (SQLException e) {
            log.info("Error executing SQL statement", e);
        } finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
    }


    @Override
    public List<Employee> getAll() {
        Connection connection = CONNECTIONPOOL.getConnection();
        List<Employee> employeeList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlAll);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("name"));
                employee.setPosition(resultSet.getString("position"));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            log.info("Error executing SQL statement", e);
        } finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
        return employeeList;
    }

    public void close() {
        Connection connection = CONNECTIONPOOL.getConnection();
        CONNECTIONPOOL.releaseConnection(connection);
    }
}



