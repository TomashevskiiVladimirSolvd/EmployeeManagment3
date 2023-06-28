package com.laba.solvd.db.dao.MapperImpl;

import com.laba.solvd.db.dao.Interfaces.ContactRepository;
import com.laba.solvd.db.model.Contact;
import com.laba.solvd.db.model.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ContactMapperImpl implements ContactRepository {
    private final SqlSession sqlSession;

    public ContactMapperImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void create(Contact contact) {
        try {
            sqlSession.insert("create", contact);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Contact> getAll() {
        try {
            return sqlSession.selectList("getAll");
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void setContact(Contact contact, Employee employee) {
        try {
            ContactRepository contactRepository = sqlSession.getMapper(ContactRepository.class);
            contactRepository.setContact(contact, employee);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}

