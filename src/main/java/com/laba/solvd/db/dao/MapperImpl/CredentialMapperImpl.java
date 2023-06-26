package com.laba.solvd.db.dao.MapperImpl;

import com.laba.solvd.db.dao.Interfaces.CredentialRepository;
import com.laba.solvd.db.dao.MyBatisInitializer;
import com.laba.solvd.db.model.Credential;
import com.laba.solvd.db.model.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CredentialMapperImpl implements CredentialRepository {
    private SqlSession sqlSession;

    public CredentialMapperImpl() {
        this.sqlSession = sqlSession;
    }

    @Override
    public void create(Credential credential) {
        sqlSession.insert("create", credential);
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
        try (SqlSession session = MyBatisInitializer.getSqlSession()) {
            CredentialRepository credentialRepository = session.getMapper(CredentialRepository.class);
            credentialRepository.setCredential(credential, employee);
            session.commit();
        }
    }
}
