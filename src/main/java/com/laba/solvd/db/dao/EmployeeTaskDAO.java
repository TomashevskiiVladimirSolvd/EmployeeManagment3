package com.laba.solvd.db.dao;

import com.laba.solvd.db.dao.Interfaces.IDao;
import com.laba.solvd.db.model.EmployeeTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTaskDAO implements IDao<EmployeeTask, Long> {
    private Connection connection;

    public EmployeeTaskDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(EmployeeTask entity) {
        try {
            String sql = "INSERT INTO EmployeesTasks (id, percentage_completed) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, entity.getId());
            statement.setInt(2, entity.getPercentageCompleted());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public EmployeeTask read(Long id) {
        EmployeeTask employeeTask = null;
        try {
            String sql = "SELECT * FROM EmployeesTasks WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                employeeTask = new EmployeeTask();
                employeeTask.setId(resultSet.getLong("id"));
                employeeTask.setPercentageCompleted(resultSet.getInt("percentage_completed"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeTask;
    }

    @Override
    public void update(EmployeeTask entity) {
        try {
            String sql = "UPDATE EmployeesTasks SET percentage_completed = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, entity.getPercentageCompleted());
            statement.setLong(2, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM EmployeesTasks WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EmployeeTask> getAll() {
        List<EmployeeTask> employeeTaskList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM EmployeesTasks";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EmployeeTask employeeTask = new EmployeeTask();
                employeeTask.setId(resultSet.getLong("id"));
                employeeTask.setPercentageCompleted(resultSet.getInt("percentage_completed"));
                employeeTaskList.add(employeeTask);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeTaskList;
    }
}
