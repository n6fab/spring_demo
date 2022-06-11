package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id; //private?
    private String name;


    public Lavoro getLavoro() {
        return lavoro;
    }

    public void setLavoro(Lavoro lavoro) {
        this.lavoro = lavoro;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lavoro_id")
    private Lavoro lavoro;

    public String getName(Iterable<Person> all) {
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
    @Override
    public String toString() {
        return this.name;
    }
    public String getName() {
        return  this.name;
    }
}