package com.laba.solvd.db.dao;
import com.laba.solvd.db.Interfaces.IDao;
import com.laba.solvd.db.domain.EmployeesTasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesTasksDAO implements IDao<EmployeesTasks, Long> {
    private Connection connection;

    public EmployeesTasksDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(EmployeesTasks entity) {
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
    public EmployeesTasks read(Long id) {
        EmployeesTasks employeesTasks = null;
        try {
            String sql = "SELECT * FROM EmployeesTasks WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                employeesTasks = new EmployeesTasks();
                employeesTasks.setId(resultSet.getLong("id"));
                employeesTasks.setPercentageCompleted(resultSet.getInt("percentage_completed"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesTasks;
    }

    @Override
    public void update(EmployeesTasks entity) {
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
    public List<EmployeesTasks> getAll() {
        List<EmployeesTasks> employeesTasksList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM EmployeesTasks";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EmployeesTasks employeesTasks = new EmployeesTasks();
                employeesTasks.setId(resultSet.getLong("id"));
                employeesTasks.setPercentageCompleted(resultSet.getInt("percentage_completed"));
                employeesTasksList.add(employeesTasks);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesTasksList;
    }
}
