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
 /*  @PrimaryKeyJoinColumn
 // @JoinColumn(name = "lavoro_id", referencedColumnName = "id" ) //primary kay of address
    private Lavoro lavoro;
    @JoinTable (
            name="person_lavoro", //""
            joinColumns = @JoinColumn(name = "lavoro_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )*/


     /*@JsonIgnore
        @ManyToMany(mappedBy = "collezioneLavori")
        private Set<Lavoro> subjects  = new HashSet<>(); //lavori
    */
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
  /*  public Set<Lavoro> getSubjects() {//getLavori
        return subjects;//lavori
    }*/
}