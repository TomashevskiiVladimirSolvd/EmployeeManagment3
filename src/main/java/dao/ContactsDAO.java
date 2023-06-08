package dao;

import Interfaces.IDao;
import model.Contacts;

import java.sql.Connection;
import java.util.List;

public class ContactsDAO implements IDao<Contacts, Long> {
    private Connection connection;
    public ContactsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Contacts entity) {

    }

    @Override
    public Contacts read(Long aLong) {
        return null;
    }

    @Override
    public void update(Contacts entity) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<Contacts> getAll() {
        return null;
    }
}
