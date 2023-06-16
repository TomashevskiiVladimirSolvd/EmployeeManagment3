package com.laba.solvd.db.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;

public class DepartmentDAO {
    Logger log = Logger.getLogger(DepartmentDAO.class.getName());
    private static final ConnectionPool CONNECTIONPOOL= ConnectionPool.getInstance();
    private final String sqlAll = "SELECT * FROM employees e JOIN contacts c ON e.id=c.employee_id " +
            "JOIN credentials cr ON e.id =cr.employee_id JOIN employees_skills es ON e.id = es.employee_id " +
            "JOIN skills s ON s.id = es.skill_id JOIN employees_trainings etr ON e.id = etr.employee_id " +
            "JOIN training_programs tp ON tp.id = etr.programs_id JOIN employees_departments ed ON e.id = ed.employee_id " +
            "JOIN departments d ON d.id = ed.department_id";
}
