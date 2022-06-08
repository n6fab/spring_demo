package com.example.demo.api;

import ch.qos.logback.core.status.Status;
import com.example.demo.dao.LavoroDao;
import com.example.demo.dao.PersonDao;
import com.example.demo.model.Lavoro;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/subjects") //lavori
public class LavoroController {
    @Autowired
    LavoroDao lavoroDao; //private?
    @Autowired
    PersonDao personDao; //private?

    @PostMapping
    public @ResponseBody String addPerson(@RequestBody Lavoro person) {
        Lavoro l = new Lavoro();
        l.setName(person.getName());
        lavoroDao.save(l);
        return "saved";
    }
    @GetMapping
    public @ResponseBody Iterable<Lavoro> getAllPerson() {
        return lavoroDao.findAll();
    }

    @GetMapping(path = "{id}")
    public Optional<Lavoro> getPersonById(@PathVariable("id") Long id) {
        return lavoroDao.findById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") Long id) {
        lavoroDao.deleteById(id);
    }

    @PutMapping(path = "{id}")
    public Optional<Lavoro> updatePost(@PathVariable Long id, @RequestBody Lavoro lavoroUpDate) {
        return lavoroDao.findById(id)
                .map(person -> {
                    person.setName(lavoroUpDate.getName());
                    return lavoroDao.save(person);
                });
    }
  /*  @PutMapping("/{lavoro_id}/person/{person_id}")
    Lavoro addPersonToLavoro(
                    @PathVariable Long lavoro_id,
                    @PathVariable Long person_id
            ) {
            Lavoro lavoro = lavoroDao.findById(lavoro_id).get();
            Person person = personDao.findById(person_id).get();
            lavoro.collezioneLavori.add(person);
            return lavoroDao.save(lavoro);
    }*/
}