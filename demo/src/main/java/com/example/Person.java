package com.example;

import java.io.Serializable;

public class Person implements Serializable {
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{id='" + id + "', name='" + name + "'}";
    }
}
