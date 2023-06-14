package com.laba.solvd.db.dao;

import com.laba.solvd.db.dao.Interfaces.IDAOProject;
import com.laba.solvd.db.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectDAO implements IDAOProject {
    private Connection connection;
    private String sqlAll = "SELECT pr.name as project,t.name as task,t.priority\n" +
            "FROM projects pr\n" +
            "JOIN tasks t ON pr.id = t.project_id;";

    public ProjectDAO() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        this.connection = connectionPool.getConnection();
    }

    @Override
    public void create(Project entity) {
        try {
            String sql = "INSERT INTO Projects (id, name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project read(Long id) {
        Project project = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sqlAll);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                project = new Project();
                project.setId(resultSet.getLong("id"));
                project.setName(resultSet.getString("name"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public void update(Project entity) {
        try {
            String sql = "UPDATE Projects SET name = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getName());
            statement.setLong(2, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        connectionPool.releaseConnection(connection);
        connection = null;
    }
}
