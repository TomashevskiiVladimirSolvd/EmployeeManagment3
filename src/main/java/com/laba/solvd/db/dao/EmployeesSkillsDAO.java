package com.laba.solvd.db.dao;
import com.laba.solvd.db.domain.EmployeesSkills;
import com.laba.solvd.db.Interfaces.IDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesSkillsDAO implements IDao<EmployeesSkills, Long> {
    private Connection connection;

    public EmployeesSkillsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(EmployeesSkills entity) {
        try {
            String sql = "INSERT INTO EmployeesSkills (id, proficiency_level) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getProficiencyLevel());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public EmployeesSkills read(Long id) {
        EmployeesSkills employeesSkills = null;
        try {
            String sql = "SELECT * FROM EmployeesSkills WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                employeesSkills = new EmployeesSkills();
                employeesSkills.setId(resultSet.getLong("id"));
                employeesSkills.setProficiencyLevel(resultSet.getString("proficiency_level"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesSkills;
    }

    @Override
    public void update(EmployeesSkills entity) {
        try {
            String sql = "UPDATE EmployeesSkills SET proficiency_level = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getProficiencyLevel());
            statement.setLong(2, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM EmployeesSkills WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EmployeesSkills> getAll() {
        List<EmployeesSkills> employeesSkillsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM EmployeesSkills";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EmployeesSkills employeesSkills = new EmployeesSkills();
                employeesSkills.setId(resultSet.getLong("id"));
                employeesSkills.setProficiencyLevel(resultSet.getString("proficiency_level"));
                employeesSkillsList.add(employeesSkills);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesSkillsList;
    }
}
