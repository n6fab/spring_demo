package com.example.demo.service.impl;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonDao personDao;
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }
    @Override
    public Person save(Person person) {
        return personDao.save(person);
    }
    @Override
    public Optional<Person> findByName(String name) {
        return personDao.findByName(name);
    }
    @Override
    public void deleteById(Long id) {
        personDao.deleteById(id);
    }
    @Override
    public Optional<Person> findById(Long id) {
        return personDao.findById(id);
    }
    @Override
    public Iterable<Person> findAll() {
        return personDao.findAll();
    }
    @Override
    public List<Person> findByChar(Character lettera) {
        return personDao.findByChar(lettera);
    }
}
