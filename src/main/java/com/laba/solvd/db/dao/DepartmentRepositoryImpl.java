package com.laba.solvd.db.dao;

import com.laba.solvd.db.dao.Interfaces.DepartmentRepository;
import com.laba.solvd.db.model.Department;
import org.apache.log4j.Logger;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository {
    Logger log = Logger.getLogger(DepartmentRepositoryImpl.class.getName());
    private static final ConnectionPool CONNECTIONPOOL = ConnectionPool.getInstance();
    private final String sqlAll = "SELECT * FROM departments";

    @Override
    public void create(Department department) {
        Connection connection = CONNECTIONPOOL.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Departments (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, department.getName());
            preparedStatement.executeUpdate();

            ResultSet ResultSet = preparedStatement.getGeneratedKeys();
            while (ResultSet.next()) {
                department.setId(ResultSet.getLong("id"));
            }
        } catch (SQLException e) {
            log.info("Error executing SQL statement", e);
        } finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }

    }

    @Override
    public List<Department> getAll() {
        Connection connection = CONNECTIONPOOL.getConnection();
        List<Department> departmentList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlAll);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getLong("id"));
                department.setName(resultSet.getString("name"));
                departmentList.add(department);
            }
        } catch (SQLException e) {
            log.info("Error executing SQL statement", e);
        } finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
        return departmentList;
    }
}
