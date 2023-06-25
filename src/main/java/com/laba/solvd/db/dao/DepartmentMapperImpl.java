package com.laba.solvd.db.dao;

import com.laba.solvd.db.dao.Interfaces.DepartmentRepository;
import com.laba.solvd.db.model.Department;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DepartmentMapperImpl implements DepartmentRepository {
    private SqlSession sqlSession;

    public DepartmentMapperImpl() {
        this.sqlSession = MyBatisInitializer.getSqlSession();
    }
    @Override
    public void create(Department department) {
        try {
            sqlSession.insert("create", department);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<Department> getAll() {
        try {
            return sqlSession.selectList("getAll");
        } finally {
            sqlSession.close();
        }
    }
}
