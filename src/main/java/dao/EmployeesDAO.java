package dao;
import Interfaces.IDao;

import model.*;

import java.sql.*;

import java.util.List;

public class EmployeesDAO implements IDao<Employees, Long> {
    private Connection connection;

    public EmployeesDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Employees entity) {
    }

    @Override
    public Employees read(Long id) {
        return null;
    }

    @Override
    public void update(Employees entity) {
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public List<Employees> getAll() {
        return null;
    }
}


