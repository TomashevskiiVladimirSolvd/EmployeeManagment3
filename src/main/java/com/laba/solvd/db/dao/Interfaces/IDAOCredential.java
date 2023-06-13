package com.laba.solvd.db.dao.Interfaces;

import com.laba.solvd.db.model.Credential;

public interface IDAOCredential {
    void create(Credential credential);

    Credential read(Long id);

    void update(Credential credential);
}
