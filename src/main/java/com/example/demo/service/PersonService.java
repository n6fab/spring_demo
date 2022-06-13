package com.example.demo.service;
import com.example.demo.model.Person;
import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person save(Person person);
    Optional <Person> findByName(String name);
    void deleteById(Long id);
    Optional<Person> findById(Long id);
    Iterable<Person> findAll();
    List<Person> findByChar(Character lettera);
}
