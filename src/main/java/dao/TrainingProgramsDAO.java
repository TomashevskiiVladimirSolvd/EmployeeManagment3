package dao;
import Interfaces.IDao;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class TrainingProgramsDAO implements IDao<TrainingPrograms, Long> {
    private Connection connection;

    public TrainingProgramsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(TrainingPrograms entity) {
        try {
            String sql = "INSERT INTO TrainingPrograms (id, name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TrainingPrograms read(Long id) {
        TrainingPrograms trainingPrograms = null;
        try {
            String sql = "SELECT * FROM TrainingPrograms WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                trainingPrograms = new TrainingPrograms();
                trainingPrograms.setId(resultSet.getLong("id"));
                trainingPrograms.setName(resultSet.getString("name"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainingPrograms;
    }

    @Override
    public void update(TrainingPrograms entity) {
        try {
            String sql = "UPDATE TrainingPrograms SET name = ? WHERE id = ?";
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
            String sql = "DELETE FROM TrainingPrograms WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TrainingPrograms> getAll() {
        List<TrainingPrograms> trainingProgramsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TrainingPrograms";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TrainingPrograms trainingPrograms = new TrainingPrograms();
                trainingPrograms.setId(resultSet.getLong("id"));
                trainingPrograms.setName(resultSet.getString("name"));
                trainingProgramsList.add(trainingPrograms);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainingProgramsList;
    }

}
