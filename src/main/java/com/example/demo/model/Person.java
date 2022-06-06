package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    private final Long id;


    private final String name;

    public Person(@JsonProperty("id") Long id,
                  @JsonProperty("name") String name) { //constructors parameters
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
