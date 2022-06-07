package com.example.demo.api;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {
    @Autowired
    private PersonDao personDao;

    @PostMapping
    public @ResponseBody String addPerson(@RequestBody String name) {
        Person p = new Person();
        p.setName(name);
        personDao.save(p);
        return "saved";
    }

    @GetMapping
    public @ResponseBody Iterable<Person> getAllPerson() {
        return personDao.findAll();
    }

    @GetMapping(path = "{id}")
    public Optional<Person> getPersonById(@PathVariable("id") Long id) {
        return personDao.findById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") Long id) {
        personDao.deleteById(id);
    }

    @PutMapping(path = "{id}")
    public Optional<Person> updatePost(@PathVariable Long id, @RequestBody Person personUpDate) {
        return personDao.findById(id)
                .map(person -> {
                    person.setName(personUpDate.getName());
                    return personDao.save(person);
                });
    }
}
