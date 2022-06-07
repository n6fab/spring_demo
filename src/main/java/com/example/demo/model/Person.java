package com.example.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id; //private?
    private String name;

    @ManyToMany(mappedBy = "enrolledStudents") //collezioneLavori
    private Set<Lavoro> subjects  = new HashSet<>(); //lavori

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId (Long id) {
        this.id = id;
    }
    public Set<Lavoro> getSubjects() {//getLavori
        return subjects;//lavori
    }
}