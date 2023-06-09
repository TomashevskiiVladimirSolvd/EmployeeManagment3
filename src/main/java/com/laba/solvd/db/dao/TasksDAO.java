package com.laba.solvd.db.dao;
import com.laba.solvd.db.Interfaces.IDao;
import com.laba.solvd.db.model.Tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TasksDAO implements IDao<Tasks, Long> {
    private Connection connection;

    public TasksDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Tasks entity) {
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
    public Tasks read(Long id) {
        Tasks tasks = null;
        try {
            String sql = "SELECT * FROM Tasks WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                tasks = new Tasks();
                tasks.setId(resultSet.getLong("id"));
                tasks.setName(resultSet.getString("name"));
                tasks.setPriority(resultSet.getString("priority"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public void update(Tasks entity) {
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
    public List<Tasks> getAll() {
        List<Tasks> tasksList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Tasks";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Tasks tasks = new Tasks();
                tasks.setId(resultSet.getLong("id"));
                tasks.setName(resultSet.getString("name"));
                tasks.setPriority(resultSet.getString("priority"));
                tasksList.add(tasks);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasksList;
    }
}
