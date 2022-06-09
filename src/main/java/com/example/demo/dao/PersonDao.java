package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonDao extends CrudRepository<Person, Long>{

    Optional<Person> findByName(String name);

}
