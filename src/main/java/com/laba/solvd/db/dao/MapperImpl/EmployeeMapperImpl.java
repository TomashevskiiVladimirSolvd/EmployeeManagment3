package com.laba.solvd.db.dao.MapperImpl;

import com.laba.solvd.db.dao.Interfaces.EmployeeRepository;
import com.laba.solvd.db.dao.MyBatisInitializer;
import com.laba.solvd.db.model.Department;
import com.laba.solvd.db.model.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployeeMapperImpl implements EmployeeRepository {
    private final SqlSession sqlSession;

    public EmployeeMapperImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void create(Employee employee) {
        sqlSession.insert("create", employee);
    }

    @Override
    public List<Employee> getAll() {
        try {
            return sqlSession.selectList("getAll");
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void setEmployee(Employee employee, Department department) {
        try (SqlSession session = MyBatisInitializer.getSqlSession()) {
            EmployeeRepository employeeRepository = session.getMapper(EmployeeRepository.class);
            employeeRepository.setEmployee(employee, department);
            session.commit();
        }
    }
}
