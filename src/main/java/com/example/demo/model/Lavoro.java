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

    /*   public Person getPerson() {
           return person;
       }

       public void setPerson(Person person) {
           this.person = person;
       }
   @OneToOne
   @MapsId
   @JoinColumn(name = "person_id")
   private Person person;
       @OneToOne*/
    /*@JsonIgnore
       @ManyToMany(mappedBy = "collezioneLavori")
       private Set<Lavoro> subjects  = new HashSet<>(); //lavori
   */
   /* @ManyToMany
    @JoinTable (
            name="person_lavoro",
            joinColumns = @JoinColumn(name = "lavoro_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    public

    Set<Person> collezioneLavori = new HashSet<>(); //collezioneLavori
*/
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
  /*  public Set<Person> getCollezioneLavori() { //getCollezioneLavori()
        return collezioneLavori; //collezioneLavori
    }*/
}
