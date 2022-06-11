package com.example.demo.api;

import com.example.demo.dao.LavoroDao;
import com.example.demo.dao.PersonDao;
import com.example.demo.model.Lavoro;
import com.example.demo.model.Person;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {
    @Autowired
    private PersonDao personDao;
    private LavoroDao lavoroDao;

    @PostMapping
       public @ResponseBody String addPerson(@RequestBody Person person) { //, Lavoro lavoro
        Person p = new Person();
        p.setName(person.getName(personDao.findAll()));
        personDao.save(p);
        return "saved";
    }
   @GetMapping
    public @ResponseBody Iterable<Person> getAllPerson() {
        return personDao.findAll();
    }

    @GetMapping(path = "/getId/{id}")
    public Optional<Person> getPersonById(@PathVariable("id") Long id) {
        return personDao.findById(id);
    }

        //getNamesByChar
     /*  @JsonRawValue
        @GetMapping(path = "/getChar/{lettera}")
         public @ResponseBody Iterable<Person> getNamesByChar(@PathVariable("lettera") Character lettera) {
            return personDao.findByChar(lettera);
         }*/
    @JsonRawValue
    @GetMapping(path = "/getChar/{lettera}")
    public @ResponseBody String getNamesByChar(@PathVariable("lettera") Character lettera) {
        Iterable<Person> p = personDao.findByChar(lettera);
        return p.toString();
    }



        /* getLavoroByPersona */
        @JsonRawValue
       @GetMapping(path = "/getLavoroByPersona/{name}")
       public @ResponseBody Optional<Lavoro> getLavoroByPersona(@PathVariable("name") String name) {
        return personDao.findByName(name)
        .map(Person::getLavoro);
       /*    .map(lavoro -> {
          return lavoro.getLavoro();
      });*/
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") Long id) {
        personDao.deleteById(id);
    }

    @PutMapping(path = "/name/{id}")
    public Optional<Person> updatePost(@PathVariable Long id, @RequestBody Person personUpDate) {
        return personDao.findById(id)
                .map(person -> {
                    person.setName(personUpDate.getName(personDao.findAll()));
                    return personDao.save(person);
                });
    }
}
