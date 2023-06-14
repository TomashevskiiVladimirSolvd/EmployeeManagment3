package com.laba.solvd.db.service.Interfaces;

import com.laba.solvd.db.model.Task;

public interface TaskRepository {
    public void create(Task task);

    public Task read(Long id);
}
