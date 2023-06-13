package com.laba.solvd.db.dao;
import com.laba.solvd.db.Interfaces.IDao;
import com.laba.solvd.db.model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TasksDAO implements IDao<Task, Long> {
    private Connection connection;

    public TasksDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Task entity) {
        try {
            String sql = "INSERT INTO Tasks (id, name, priority) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getPriority());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Task read(Long id) {
        Task task = null;
        try {
            String sql = "SELECT * FROM Tasks WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                task = new Task();
                task.setId(resultSet.getLong("id"));
                task.setName(resultSet.getString("name"));
                task.setPriority(resultSet.getString("priority"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    @Override
    public void update(Task entity) {
        try {
            String sql = "UPDATE Tasks SET name = ?, priority = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getPriority());
            statement.setLong(3, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM Tasks WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> getAll() {
        List<Task> taskList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Tasks";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getLong("id"));
                task.setName(resultSet.getString("name"));
                task.setPriority(resultSet.getString("priority"));
                taskList.add(task);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskList;
    }
}
