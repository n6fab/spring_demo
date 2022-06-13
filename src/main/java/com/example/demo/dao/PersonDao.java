package com.example.demo.dao;

import com.example.demo.model.Person;
import org.hibernate.annotations.NotFound;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.List;
import java.util.Optional;

public interface PersonDao extends CrudRepository<Person, Long>{

    Optional<Person> findByName(String name);

    @Query("select p from Person p where p.name like ?1%")
    List<Person> findByChar(Character lettera);

}
