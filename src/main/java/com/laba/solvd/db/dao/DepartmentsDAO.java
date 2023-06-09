package com.laba.solvd.db.dao;

import com.laba.solvd.db.Interfaces.IDao;
import com.laba.solvd.db.domain.Departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsDAO implements IDao<Departments, Long> {
    private Connection connection;

    public DepartmentsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Departments entity) {
        try {
            String sql = "INSERT INTO Departments (id, name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Departments read(Long id) {
        Departments department = null;
        try {
            String sql = "SELECT * FROM Departments WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                department = new Departments();
                department.setId(resultSet.getLong("id"));
                department.setName(resultSet.getString("name"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public void update(Departments entity) {
        try {
            String sql = "UPDATE Departments SET name = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getName());
            statement.setLong(2, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM Departments WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Departments> getAll() {
        List<Departments> departmentsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Departments";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Departments department = new Departments();
                department.setId(resultSet.getLong("id"));
                department.setName(resultSet.getString("name"));
                departmentsList.add(department);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentsList;
    }

}