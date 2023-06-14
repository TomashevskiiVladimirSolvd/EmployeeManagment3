package com.laba.solvd.db.dao.Interfaces;

import com.laba.solvd.db.model.Task;

import java.util.List;


public interface IDAOTask {
    void create(Task task);

    Task read(Long id);

    void update(Task task);

    List<Task> getAll();
}
