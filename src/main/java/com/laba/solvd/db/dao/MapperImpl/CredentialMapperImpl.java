package com.laba.solvd.db.dao.MapperImpl;

import com.laba.solvd.db.dao.Interfaces.CredentialRepository;
import com.laba.solvd.db.model.Credential;
import com.laba.solvd.db.model.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CredentialMapperImpl implements CredentialRepository {
    private final SqlSession sqlSession;

    public CredentialMapperImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void create(Credential credential) {
        try {
            CredentialRepository credentialRepository = sqlSession.getMapper(CredentialRepository.class);
            credentialRepository.create(credential);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Credential> getAll() {
        try {
            return sqlSession.selectList("getAll");
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void setCredential(Credential credential, Employee employee) {
        try {
            CredentialRepository credentialRepository = sqlSession.getMapper(CredentialRepository.class);
            credentialRepository.setCredential(credential, employee);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}

