package com.laba.solvd.db.service.Interfaces;

import com.laba.solvd.db.model.Project;

public interface ProjectRepository {
    public void create(Project project);

    public Project readAll(Long id);
}
