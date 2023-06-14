package com.laba.solvd.db.service;

import com.laba.solvd.db.dao.TaskDAO;
import com.laba.solvd.db.model.Task;
import com.laba.solvd.db.service.Interfaces.TaskRepository;

public class TaskServiceImpl implements TaskRepository {
    private  TaskDAO taskDAO ;

    public TaskServiceImpl(TaskDAO taskDAO){
        this.taskDAO=taskDAO;
    }
    @Override
    public void create(Task task) {
        taskDAO.create(task);
    }

    @Override
    public Task read(Long id) {
        return taskDAO.read(id);
    }
}
