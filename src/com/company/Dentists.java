package com.company;

import java.io.Serializable;

public class Dentists implements Serializable {

    private Long id;
    private String name;
    private String time;

    public Dentists(){}

    public Dentists(Long id, String name, String time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Dentists{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
