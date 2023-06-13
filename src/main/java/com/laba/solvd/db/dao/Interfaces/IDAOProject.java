package com.laba.solvd.db.dao.Interfaces;

import com.laba.solvd.db.model.Project;
import com.laba.solvd.db.model.Task;

import java.util.List;

public interface IDAOProject {
    void create(Project project);

    Project read(Long id);

    void update(Project project);

}
