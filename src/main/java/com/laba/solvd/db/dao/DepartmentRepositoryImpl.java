package com.laba.solvd.db.dao;

import com.laba.solvd.db.dao.Interfaces.DepartmentRepository;
import com.laba.solvd.db.model.Department;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository {
    Logger log = Logger.getLogger(DepartmentRepositoryImpl.class.getName());
    private static final ConnectionPool CONNECTIONPOOL = ConnectionPool.getInstance();
    private final String sqlAll = "SELECT d.id as department_id, d.name as department,e.id as employee_id ,\n" +
            "e.name as employee,e.position as position,cr.id as credential_id,cr.login as login ,cr.password as password,\n" +
            "c.id as contact_id,c.email as email,c.phone as phone \n" +
            "From departments d\n" +
            "LEFT JOIN employees_departments ed ON d.id =ed.department_id\n" +
            "LEFT JOIN employees e ON e.id = ed.employee_id\n" +
            "LEFT JOIN contacts c ON e.id =c.employee_id\n" +
            "LEFT JOIN credentials cr ON e.id =cr.employee_id;\n ";

    @Override
    public void create(Department department) {
        Connection connection = CONNECTIONPOOL.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Departments (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, department.getName());
            preparedStatement.executeUpdate();

            ResultSet ResultSet = preparedStatement.getGeneratedKeys();
            while (ResultSet.next()) {
                department.setId(ResultSet.getLong("id"));
            }
        } catch (SQLException e) {
            log.info("Error executing SQL statement", e);
        } finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }

    }

    @Override
    public List<Department> getAll() {
        Connection connection = CONNECTIONPOOL.getConnection();
        List<Department> departmentList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlAll);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getLong("id"));
                department.setName(resultSet.getString("name"));
                departmentList.add(department);
            }
        } catch (SQLException e) {
            log.info("Error executing SQL statement", e);
        } finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
        return departmentList;
    }
}
