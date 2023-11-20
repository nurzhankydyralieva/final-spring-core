package com.epam.project.model;

public class Trainer {
    private Integer id;
    private Specialization specialization;
    private String name;
    private User user;

    public Trainer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Trainer(Specialization specialization, User user) {
        this.specialization = specialization;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
