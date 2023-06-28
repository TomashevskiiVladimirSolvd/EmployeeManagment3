package com.laba.solvd.db;

import com.laba.solvd.db.dao.Interfaces.*;
import com.laba.solvd.db.dao.MapperImpl.ContactMapperImpl;
import com.laba.solvd.db.dao.MapperImpl.CredentialMapperImpl;
import com.laba.solvd.db.dao.MapperImpl.DepartmentMapperImpl;
import com.laba.solvd.db.dao.MapperImpl.EmployeeMapperImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;


public class MyBatisDAOFactory implements DAOFactory {
    private static final String MYBATIS_CONFIG_FILE = "src/main/resources/mybatis-config.xml";
    private SqlSessionFactory sqlSessionFactory;

    public MyBatisDAOFactory() {
        initialize();
    }

    private void initialize() {
        try (Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG_FILE)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize MyBatis DAO factory", e);
        }
    }

    @Override
    public DepartmentRepository createDepartmentRepository() {
        return new DepartmentMapperImpl(createSqlSession());
    }

    @Override
    public EmployeeRepository createEmployeeRepository() {
        return new EmployeeMapperImpl(createSqlSession());
    }

    @Override
    public CredentialRepository createCredentialRepository() {
        return new CredentialMapperImpl(createSqlSession());
    }

    @Override
    public ContactRepository createContactRepository() {
        return new ContactMapperImpl(createSqlSession());
    }

    public SqlSession createSqlSession() {
        return sqlSessionFactory.openSession();
    }
}






