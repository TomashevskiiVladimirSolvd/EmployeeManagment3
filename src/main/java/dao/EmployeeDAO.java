package dao;

import model.Employees;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class EmployeeDAO {
    public Employees getUserById(long id) throws SQLException {
        Employees employee = new Employees();
        Properties props = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            props.load(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (Connection connection = DriverManager.getConnection(props.getProperty("db.url"), props)) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID=? ");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("name"));
            }
        }
        return employee;
    }

    public static void main(String[] args) throws SQLException {
        Employees employee= new EmployeeDAO().getUserById(1);
        System.out.println(employee.toString());
    }
}

