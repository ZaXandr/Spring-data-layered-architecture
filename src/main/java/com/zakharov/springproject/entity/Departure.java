package com.zakharov.springproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Departure {

    @Id
    private int id;
    private String name;
    private String location;

    public Departure() {
    }

    public Departure(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

