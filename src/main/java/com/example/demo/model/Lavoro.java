package com.example.demo.model;

import ch.qos.logback.core.BasicStatusManager;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Lavoro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id; //private?
    private String name;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
