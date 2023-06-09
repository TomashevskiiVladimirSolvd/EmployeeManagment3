package com.laba.solvd.db.dao;
import com.laba.solvd.db.model.EmployeesTrainings;
import com.laba.solvd.db.Interfaces.IDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesTrainingsDAO implements IDao<EmployeesTrainings, Long> {
    private Connection connection;

    public EmployeesTrainingsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(EmployeesTrainings entity) {
        try {
            String sql = "INSERT INTO EmployeesTrainings (id, status) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public EmployeesTrainings read(Long id) {
        EmployeesTrainings employeesTrainings = null;
        try {
            String sql = "SELECT * FROM EmployeesTrainings WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                employeesTrainings = new EmployeesTrainings();
                employeesTrainings.setId(resultSet.getLong("id"));
                employeesTrainings.setStatus(resultSet.getString("status"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesTrainings;
    }

    @Override
    public void update(EmployeesTrainings entity) {
        try {
            String sql = "UPDATE EmployeesTrainings SET status = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getStatus());
            statement.setLong(2, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM EmployeesTrainings WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EmployeesTrainings> getAll() {
        List<EmployeesTrainings> employeesTrainingsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM EmployeesTrainings";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EmployeesTrainings employeesTrainings = new EmployeesTrainings();
                employeesTrainings.setId(resultSet.getLong("id"));
                employeesTrainings.setStatus(resultSet.getString("status"));
                employeesTrainingsList.add(employeesTrainings);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesTrainingsList;
    }
}
