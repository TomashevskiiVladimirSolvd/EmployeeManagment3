package com.laba.solvd.db.dao.Interfaces;

import com.laba.solvd.db.model.Credential;
import com.laba.solvd.db.model.Department;
import com.laba.solvd.db.model.Employee;

import java.util.List;

public interface CredentialRepository {
    void create(Credential credential);

    List<Credential> getAll();

    void setCredential(Credential credential, Employee employee);
}
