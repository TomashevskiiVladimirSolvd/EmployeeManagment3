package com.laba.solvd.db.dao;

import com.laba.solvd.db.dao.Interfaces.ContactRepository;
import com.laba.solvd.db.model.Contact;
import com.laba.solvd.db.model.Credential;
import com.laba.solvd.db.model.Employee;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {
    Logger log = Logger.getLogger(ContactRepositoryImpl.class.getName());
    private static final ConnectionPool CONNECTIONPOOL = ConnectionPool.getInstance();

    private final String sqlAll = "SELECT c.id as contact_id,c.email as contact_email,c.phone as contact_phone  FROM contacts c";

    @Override
    public void create(Contact contact) {
        Connection connection = CONNECTIONPOOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Contacts ( email, phone) VALUES ( ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, contact.getEmail());
            preparedStatement.setString(2, contact.getPhone());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                contact.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            log.info("Unable to create contacts", e);
        } finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
    }

    @Override
    public List<Contact> getAll() {
        Connection connection = CONNECTIONPOOL.getConnection();
        List<Contact> contactList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlAll);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getLong("contact_id"));
                contact.setEmail(resultSet.getString("contact_email"));
                contact.setPhone(resultSet.getString("contact_login"));
                contactList.add(contact);
            }
        } catch (SQLException e) {
            log.info("Error executing SQL statement", e);
        } finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
        return contactList;
    }

    @Override
    public void setContact(Contact contact, Employee employee) {
        Connection connection = null;
        String sql = "INSERT INTO contacts (id,employee_id) VALUES(?,?)";
        try{
            connection = CONNECTIONPOOL.getConnection();
            PreparedStatement statement =connection.prepareStatement(sql);
            statement.setLong(1,contact.getId());
            statement.setLong(2,employee.getId());
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e) {
            log.info("Failed to connect", e);
        }finally {
            CONNECTIONPOOL.releaseConnection(connection);
        }
    }

    public static void mapRow(ResultSet resultSet, List<Contact> contacts) throws SQLException {
        contacts.add(mapRow(resultSet));
    }

    public static Contact mapRow(ResultSet resultSet) throws SQLException {
        Contact contact = null;

        long id = resultSet.getLong("contact_id");
        if (id != 0) {
            contact = new Contact();
            contact.setId(resultSet.getLong("contact_id"));
            contact.setEmail(resultSet.getString("contact_email"));
            contact.setPhone(resultSet.getString("contact_phone"));
        }

        return contact;
    }
}
