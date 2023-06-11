package com.laba.solvd.db.Interfaces;

import com.laba.solvd.db.model.Credentials;

import java.util.List;
import java.util.Optional;

public interface CredentialsRepository {
    void create(Credentials credentials);
    Optional<Credentials> findById(Long id);
    List<Credentials> findAll();
    void update(Credentials credentials);

    void deleteById(Long id);
}
