package com.laba.solvd.db.dao.MapperImpl;

import com.laba.solvd.db.dao.Interfaces.ContactRepository;
import com.laba.solvd.db.dao.MyBatisInitializer;
import com.laba.solvd.db.model.Contact;
import com.laba.solvd.db.model.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ContactMapperImpl implements ContactRepository {
    private SqlSession sqlSession;

    public ContactMapperImpl() {
        this.sqlSession = sqlSession;
    }

    @Override
    public void create(Contact contact) {
        sqlSession.insert("create", contact);
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
        try (SqlSession session = MyBatisInitializer.getSqlSession()) {
            ContactRepository contactRepository = session.getMapper(ContactRepository.class);
            contactRepository.setContact(contact, employee);
            session.commit();
        }
    }
}
