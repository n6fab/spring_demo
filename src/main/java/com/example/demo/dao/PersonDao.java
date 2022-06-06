package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(Person person); // inserire una persona con un determinato ID

    Optional<Person> selectPersonById(Long id);
    List<Person> selectAllPeople();
    int deletePersonById(Long id);
    int updatePersonById(Long id, Person person);
}
