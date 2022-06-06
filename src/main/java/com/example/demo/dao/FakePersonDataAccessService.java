package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(Person person) {
        DB.add(new Person((long) (DB.size()+1), person.getName())); // per inserire una persona aggiungerla al DB
        return 1; // per sapere che funziona
    }

    @Override
    public Optional<Person> selectPersonById(Long id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public int deletePersonById(Long id) {// elimina o return 0
        Optional<Person> personMaybe  = selectPersonById(id);
                if (personMaybe.isEmpty()) {
                    return 0;
                }
        DB.remove(personMaybe.get());
                return 1;
    }

    @Override
    public int updatePersonById(Long id, Person update) {
        return selectPersonById(id)
                .map(person -> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}