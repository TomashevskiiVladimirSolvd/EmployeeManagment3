package com.laba.solvd.db.dao;

import com.laba.solvd.db.dao.Interfaces.DepartmentRepository;
import com.laba.solvd.db.model.Department;
import com.laba.solvd.db.model.Employee;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository {
    private static final ConnectionPool CONNECTIONPOOL = ConnectionPool.getInstance();
    private final String sqlAll = "SELECT d.id as department_id, d.name as department_name,e.id as employee_id ,\n" +
            "e.name as employee,e.position as position,cr.id as credential_id,cr.login as login ,cr.password as password,\n" +
            "c.id as contact_id,c.email as email,c.phone as phone \n" +
            "From departments d\n" +
            "LEFT JOIN employees_departments ed ON d.id =ed.department_id\n" +
            "LEFT JOIN employees e ON e.id = ed.employee_id\n" +
            "LEFT JOIN contacts c ON e.id =c.employee_id\n" +
            "LEFT JOIN credentials cr ON e.id =cr.employee_id;\n ";
    Logger log = Logger.getLogger(DepartmentRepositoryImpl.class.getName());

    private static Department findById(Long id, List<Department> departments) {
        return departments.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    Department createdDepartment = new Department();
                    createdDepartment.setId(id);
                    departments.add(createdDepartment);
                    return createdDepartment;
                });
    }

    private static List<Department> mapDepartments(ResultSet resultSet) throws SQLException {
        List<Department> departments = new ArrayList<>();
        while (resultSet.next()) {
            Long id = resultSet.getLong("department_id");
            Department department = findById(id, departments);
            department.setName(resultSet.getString("department_name"));

            List<Employee> employees = EmployeeRepositoryImpl.mapRow(resultSet, department.getEmployee());
            department.setEmployees(employees);
        }
        return departments;
    }

    @Override
    public void create(Department department) {
        Connection connection = CONNECTIONPOOL.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO departments (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
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
        List<Department> departments = null;
        Connection connection = CONNECTIONPOOL.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sqlAll)) {
            ResultSet resultSet = statement.executeQuery();
            departments = mapDepartments(resultSet);

        } catch (SQLException e) {
            log.info("Unable to find all departments", e);
        } finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
        return departments;
    }

}
