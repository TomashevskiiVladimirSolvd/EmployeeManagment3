package com.laba.solvd.db.dao;

import com.laba.solvd.db.dao.Interfaces.EmployeeRepository;
import com.laba.solvd.db.model.Department;
import com.laba.solvd.db.model.Employee;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final Logger log = Logger.getLogger(EmployeeRepositoryImpl.class.getName());
    private static final ConnectionPool CONNECTIONPOOL = ConnectionPool.getInstance();
    private final String sqlAll = "SELECT e.id as employee_id ,e.name as employee_name,e.position as employee_position ,\n" +
            "cr.login as login ,cr.password as password,c.email as email,c .phone as phone\n" +
            "FROM employees e \n" +
            "LEFT JOIN credentials cr ON e.id = cr.employee_id\n" +
            "LEFT JOIN contacts c ON e.id =c.employee_id;";

    @Override
    public void create(Employee employee) {
        Connection connection = CONNECTIONPOOL.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Employees (name, position) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getPosition());
            preparedStatement.executeUpdate();

            ResultSet ResultSet = preparedStatement.getGeneratedKeys();
            while (ResultSet.next()) {
                employee.setId(ResultSet.getLong("id"));
            }
        } catch (SQLException e) {
            log.info("Error executing SQL statement", e);
        } finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
    }


    @Override
    public List<Employee> getAll() {
        Connection connection = CONNECTIONPOOL.getConnection();
        List<Employee> employeeList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlAll);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("employee_id"));
                employee.setName(resultSet.getString("employee_name"));
                employee.setPosition(resultSet.getString("employee_position"));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            log.info("Error executing SQL statement", e);
        } finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
        return employeeList;
    }

    private static Employee findById(Long id, List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst().orElseGet(() -> {
                    Employee createdEmployee = new Employee();
                    createdEmployee.setId(id);
                    employees.add(createdEmployee);
                    return createdEmployee;
                });
    }

    public static List<Employee> mapRow(ResultSet resultSet, List<Employee> employees) throws SQLException {
        long id = resultSet.getLong("id");

        if (id != 0) {
            if (employees == null) {
                employees = new ArrayList<>();
            }

            Employee employee = findById(id, employees);
            employee.setName(resultSet.getString("name"));
            employee.setPosition(resultSet.getString("position"));

            employee.setCredential(CredentialRepositoryImpl.mapRow(resultSet));
            employee.setContact(ContactRepositoryImpl.mapRow(resultSet));

        }
        return employees;
    }
    @Override
    public void setEmployee( Employee employee,Department department) {
        Connection connection = null;
        String sql = "INSERT INTO employees_departments (employee_id,department_id) VALUES(?,?)";
        try{
            connection = CONNECTIONPOOL.getConnection();
            PreparedStatement statement =connection.prepareStatement(sql);
            statement.setLong(1,employee.getId());
            statement.setLong(2,department.getId());
            statement.executeUpdate();
            statement.close();

        }catch(SQLException e) {
            log.info("Failed to connect", e);
        }finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
    }


}




