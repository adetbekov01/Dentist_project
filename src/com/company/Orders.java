package com.company;

import java.io.Serializable;

public class Orders implements Serializable {

    private Long id;
    private int dentistsId;
    private String name;
    private String surname;

    public Orders(){}

    public Orders(Long id, int dentistsId, String name, String surname) {
        this.id = id;
        this.dentistsId = dentistsId;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public int getDentistsId() {
        return dentistsId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDentistsId(int dentistsId) {
        this.dentistsId = dentistsId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", dentistsId=" + dentistsId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
