package com.laba.solvd.db.dao;

import com.laba.solvd.db.dao.Interfaces.IDaoEmployee;
import com.laba.solvd.db.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IDaoEmployee {
    private Connection connection;
    String sqlAll = "SELECT *\n" +
            "FROM employees e\n" +
            "JOIN contacts c ON e.id=c.employee_id\n" +
            "JOIN credentials cr ON e.id =cr.employee_id\n" +
            "JOIN employees_skills es ON e.id = es.employee_id\n" +
            "JOIN skills s ON s.id = es.skill_id\n" +
            "JOIN employees_trainings etr ON e.id = etr.employee_id\n" +
            "JOIN training_programs tp ON tp.id = etr.programs_id\n" +
            "JOIN employees_departments ed ON e.id = ed.employee_id\n" +
            "JOIN departments d ON d.id = ed.department_id\n" ;

    public EmployeeDAO() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        this.connection = connectionPool.getConnection();
    }

    @Override
    public void create(Employee entity) {
        try {
            String sql = "INSERT INTO Employees ( name, position) VALUES ( ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getPosition());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sqlAll);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("name"));
                employee.setPosition(resultSet.getString("position"));
                employeeList.add(employee);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public void close() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        connectionPool.releaseConnection(connection);
        connection = null;
    }
}



