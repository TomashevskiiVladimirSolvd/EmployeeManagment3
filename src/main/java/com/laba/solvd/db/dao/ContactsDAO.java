package com.laba.solvd.db.dao;

import com.laba.solvd.db.model.Contacts;
import com.laba.solvd.db.Interfaces.IDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactsDAO implements IDao<Contacts, Long> {
    private Connection connection;

    public ContactsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Contacts entity) {
        try {
            String sql = "INSERT INTO Contacts (id, email, phone) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getEmail());
            statement.setString(3, entity.getPhone());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Contacts read(Long id) {
        Contacts contact = null;
        try {
            String sql = "SELECT * FROM Contacts WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                contact = new Contacts();
                contact.setId(resultSet.getLong("id"));
                contact.setEmail(resultSet.getString("email"));
                contact.setPhone(resultSet.getString("phone"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contact;
    }

    @Override
    public void update(Contacts entity) {
        try {
            String sql = "UPDATE Contacts SET email = ?, phone = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getEmail());
            statement.setString(2, entity.getPhone());
            statement.setLong(3, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM Contacts WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contacts> getAll() {
        List<Contacts> contactsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Contacts";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Contacts contact = new Contacts();
                contact.setId(resultSet.getLong("id"));
                contact.setEmail(resultSet.getString("email"));
                contact.setPhone(resultSet.getString("phone"));
                contactsList.add(contact);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactsList;
    }

}
