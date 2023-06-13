package com.laba.solvd.db.dao;

import com.laba.solvd.db.Interfaces.IDao;
import com.laba.solvd.db.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsDAO implements IDao<Department, Long> {
    private Connection connection;

    public DepartmentsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Department entity) {
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
    public Department read(Long id) {
        Department department = null;
        try {
            String sql = "SELECT * FROM Departments WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                department = new Department();
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
    public void update(Department entity) {
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
    public List<Department> getAll() {
        List<Department> departmentList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Departments";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getLong("id"));
                department.setName(resultSet.getString("name"));
                departmentList.add(department);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }

}