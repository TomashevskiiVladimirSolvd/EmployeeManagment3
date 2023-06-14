package com.laba.solvd.db.model;

import java.util.List;
import java.util.Objects;

public class Employee {
    private long id;
    private String name;
    private String position;
    private Contact contact;
    private Credential credential;
    private List<EmployeeSkill> skills;
    private List<EmployeeTask> tasks;
    private List<EmployeeTraining> trainings;

    public Employee() {
    }

    ;

    public Employee(long id, String name, String position,Contact contact,Credential credential,List<EmployeeSkill> skills,
     List<EmployeeTask> tasks,  List<EmployeeTraining> trainings) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.contact=contact;
        this.credential=credential;
        this.tasks=tasks;
        this.trainings=trainings;
    }

    public List<EmployeeTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<EmployeeTask> tasks) {
        this.tasks = tasks;
    }

    public List<EmployeeTraining> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<EmployeeTraining> trainings) {
        this.trainings = trainings;
    }

    public List<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public Credential getCredentials() {
        return credential;
    }

    public void setCredentials(Credential credential) {
        this.credential = credential;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(position, employee.position) && Objects.equals(contact, employee.contact) && Objects.equals(credential, employee.credential) && Objects.equals(skills, employee.skills) && Objects.equals(tasks, employee.tasks) && Objects.equals(trainings, employee.trainings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, position, contact, credential, skills, tasks, trainings);
    }
}
