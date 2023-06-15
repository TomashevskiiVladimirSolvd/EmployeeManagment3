package com.laba.solvd.db.service;

import com.laba.solvd.db.dao.ProjectDAO;
import com.laba.solvd.db.model.Project;
import com.laba.solvd.db.service.Interfaces.ProjectRepository;

public class ProjectServiceImpl implements ProjectRepository {
    private ProjectDAO projectDAO;

    public ProjectServiceImpl(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public void create(Project project) {
        projectDAO.create(project);
    }

    @Override
    public Project get(Long id) {
        return projectDAO.read(id);
    }
}
