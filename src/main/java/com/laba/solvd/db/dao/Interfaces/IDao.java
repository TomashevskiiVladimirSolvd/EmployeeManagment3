package com.laba.solvd.db.dao.Interfaces;

import java.util.List;

public interface IDao<T, ID> {

    void create(T entity);

    void update(T entity);

    void delete(ID id);

    List<T> getAll();

}
