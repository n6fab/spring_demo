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

    @ManyToMany
    @JoinTable (
            name="student_enrolled", //"person_lavoro"
            joinColumns = @JoinColumn(name = "lavoro_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    public

    Set<Person> enrolledStudents = new HashSet<>(); //collezioneLavori

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
    public Set<Person> getEnrolledStudents() { //getCollezioneLavori()
        return enrolledStudents; //collezioneLavori
    }
}
