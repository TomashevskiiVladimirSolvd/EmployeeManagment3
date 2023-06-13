package com.laba.solvd.db.dao;
import com.laba.solvd.db.model.Skill;
import com.laba.solvd.db.Interfaces.IDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillsDAO implements IDao<Skill, Long> {
    private Connection connection;

    public SkillsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Skill entity) {
        try {
            String sql = "INSERT INTO Skills (id, name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Skill read(Long id) {
        Skill skill = null;
        try {
            String sql = "SELECT * FROM Skills WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                skill = new Skill();
                skill.setId(resultSet.getLong("id"));
                skill.setName(resultSet.getString("name"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }

    @Override
    public void update(Skill entity) {
        try {
            String sql = "UPDATE Skills SET name = ? WHERE id = ?";
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
            String sql = "DELETE FROM Skills WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> skillList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Skills";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Skill skill = new Skill();
                skill.setId(resultSet.getLong("id"));
                skill.setName(resultSet.getString("name"));
                skillList.add(skill);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skillList;
    }
}
