package com.laba.solvd.db.dao;
import com.laba.solvd.db.model.EmployeeTraining;
import com.laba.solvd.db.Interfaces.IDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesTrainingsDAO implements IDao<EmployeeTraining, Long> {
    private Connection connection;

    public EmployeesTrainingsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(EmployeeTraining entity) {
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
    public EmployeeTraining read(Long id) {
        EmployeeTraining employeeTraining = null;
        try {
            String sql = "SELECT * FROM EmployeesTrainings WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                employeeTraining = new EmployeeTraining();
                employeeTraining.setId(resultSet.getLong("id"));
                employeeTraining.setStatus(resultSet.getString("status"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeTraining;
    }

    @Override
    public void update(EmployeeTraining entity) {
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
    public List<EmployeeTraining> getAll() {
        List<EmployeeTraining> employeeTrainingList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM EmployeesTrainings";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EmployeeTraining employeeTraining = new EmployeeTraining();
                employeeTraining.setId(resultSet.getLong("id"));
                employeeTraining.setStatus(resultSet.getString("status"));
                employeeTrainingList.add(employeeTraining);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeTrainingList;
    }
}
