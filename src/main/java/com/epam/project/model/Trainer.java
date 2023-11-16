package com.epam.project.model;

public class Trainer {
    private Integer id;
    private Specialization specialization;
    private String name;
    private User user;

    public Trainer() {
    }


    public Trainer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Trainer(Specialization specialization, User user) {
        this.specialization = specialization;
        this.user = user;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public void setName(String name) {
        this.name = name;
    }
}
