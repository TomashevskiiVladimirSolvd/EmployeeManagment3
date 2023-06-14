package com.laba.solvd.db.dao;

import com.laba.solvd.db.dao.Interfaces.IDAOEmployeeTask;
import com.laba.solvd.db.model.EmployeeTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTaskDAO implements IDAOEmployeeTask {
    private Connection connection;
    private String sqlAll = "SELECT * FROM employees e JOIN employees_tasks et ON e.id = et.employee_id\n" +
            "JOIN tasks t ON t.id = et.task_id";

    public EmployeeTaskDAO() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        this.connection = connectionPool.getConnection();
    }

    @Override
    public void create(EmployeeTask employeeTask) {
        try {
            String sql = "INSERT INTO EmployeesTasks (id, percentage_completed) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, employeeTask.getId());
            statement.setInt(2, employeeTask.getPercentageCompleted());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    public List<EmployeeTask> getAll() {
        List<EmployeeTask> employeeTaskList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sqlAll);
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

    public void close() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        connectionPool.releaseConnection(connection);
        connection = null;
    }
}
