package com.epam.project.model;

import java.util.Date;

public class Trainee {
    private Integer id;
    private Date dateOfBirth;
    private String address;
    private User user;

    public Trainee(Integer id, Date dateOfBirth, String address) {
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Trainee(Integer id, String address) {
        this.id = id;
        this.address = address;
    }

    public Trainee(Date dateOfBirth, String address, User user) {
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + id +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", user=" + user +
                '}';
    }
}
