package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<Person, Long>{


   // int insertPerson(Person person); inserire una persona con un determinato ID
/*
    Optional<Person> selectPersonById(Long id);
    List<Person> selectAllPeople();
    int deletePersonById(Long id);
    int updatePersonById(Long id, Person person);*/
}
