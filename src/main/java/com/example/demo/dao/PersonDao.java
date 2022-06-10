package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonDao extends CrudRepository<Person, Long>{

    Optional<Person> findByName(String name);

    @Query(value = "SELECT * FROM Person WHERE name like 'p_%'", nativeQuery = true)
    Iterable<Person> findByChar(Character lettera);

    /*@Query(value = "SELECT * FROM Person WHERE name like lettera%", nativeQuery = true)
    Optional<Person> findByChar(Character lettera);*/
    //"SELECT * FROM Person WHERE name = ?1", nativeQuery = true)
            //("select * from Person where name like 'P%'")///%?1")

}
