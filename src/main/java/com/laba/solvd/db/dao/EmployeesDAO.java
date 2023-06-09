package com.laba.solvd.db.dao;
import com.laba.solvd.db.Interfaces.IDao;
import com.laba.solvd.db.model.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO implements IDao<Employees, Long> {
    private Connection connection;

    public EmployeesDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Employees entity) {
        try {
            String sql = "INSERT INTO Employees (id, name, position) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getPosition());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employees read(Long id) {
        Employees employee = null;
        try {
            String sql = "SELECT * FROM Employees WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                employee = new Employees();
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("name"));
                employee.setPosition(resultSet.getString("position"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void update(Employees entity) {
        try {
            String sql = "UPDATE Employees SET name = ?, position = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getPosition());
            statement.setLong(3, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM Employees WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employees> getAll() {
        List<Employees> employeesList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Employees";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employees employee = new Employees();
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("name"));
                employee.setPosition(resultSet.getString("position"));
                employeesList.add(employee);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesList;
    }

}


