package dao;
import Interfaces.IDao;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDAO implements IDao<Projects, Long> {
    private Connection connection;

    public ProjectsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Projects entity) {
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
    public Projects read(Long id) {
        Projects projects = null;
        try {
            String sql = "SELECT * FROM Projects WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                projects = new Projects();
                projects.setId(resultSet.getLong("id"));
                projects.setName(resultSet.getString("name"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    @Override
    public void update(Projects entity) {
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

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM Projects WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Projects> getAll() {
        List<Projects> projectsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Projects";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Projects projects = new Projects();
                projects.setId(resultSet.getLong("id"));
                projects.setName(resultSet.getString("name"));
                projectsList.add(projects);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectsList;
    }

}
