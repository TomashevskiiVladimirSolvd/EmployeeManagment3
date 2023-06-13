package com.laba.solvd.db.dao;
import com.laba.solvd.db.model.EmployeeSkill;
import com.laba.solvd.db.Interfaces.IDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesSkillsDAO implements IDao<EmployeeSkill, Long> {
    private Connection connection;

    public EmployeesSkillsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(EmployeeSkill entity) {
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
    public EmployeeSkill read(Long id) {
        EmployeeSkill employeeSkill = null;
        try {
            String sql = "SELECT * FROM EmployeesSkills WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                employeeSkill = new EmployeeSkill();
                employeeSkill.setId(resultSet.getLong("id"));
                employeeSkill.setProficiencyLevel(resultSet.getString("proficiency_level"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeSkill;
    }

    @Override
    public void update(EmployeeSkill entity) {
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
    public List<EmployeeSkill> getAll() {
        List<EmployeeSkill> employeeSkillList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM EmployeesSkills";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EmployeeSkill employeeSkill = new EmployeeSkill();
                employeeSkill.setId(resultSet.getLong("id"));
                employeeSkill.setProficiencyLevel(resultSet.getString("proficiency_level"));
                employeeSkillList.add(employeeSkill);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeSkillList;
    }
}
