package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person); // inserire una persona con un determinato ID
    default int insertPerson(Person person) { // inserire senza ID e l’ID è generato random
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
    Optional<Person> selectPersonById(UUID id);
    List<Person> selectAllPeople();
    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person person);
}
