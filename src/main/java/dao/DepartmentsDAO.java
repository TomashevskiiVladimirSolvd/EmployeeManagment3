package dao;

import Interfaces.IDao;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsDAO implements IDao<Departments, Long> {
        private Connection connection;
        public DepartmentsDAO(Connection connection) {
            this.connection = connection;
        }

    @Override
    public void create(Departments entity) {

    }

    @Override
    public Departments read(Long aLong) {
        return null;
    }

    @Override
    public void update(Departments entity) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<Departments> getAll() {
        return null;
    }
}

