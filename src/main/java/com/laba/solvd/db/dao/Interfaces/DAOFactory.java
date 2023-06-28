package com.laba.solvd.db.dao.Interfaces;

import org.apache.ibatis.session.SqlSession;

public interface DAOFactory {
    DepartmentRepository createDepartmentRepository();

    EmployeeRepository createEmployeeRepository();

    CredentialRepository createCredentialRepository();

    ContactRepository createContactRepository();


    SqlSession createSqlSession();
}
