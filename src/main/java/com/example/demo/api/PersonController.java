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
       public @ResponseBody String addPerson (@RequestBody String name) {
            // @ResponseBody means the returned String is the response, not a view name
            // @RequestParam means it is a parameter from the GET or POST request
        Person n = new Person();
        n.setName(name);
        personDao.save(n);
        return "saved";
    }
    @GetMapping
    public @ResponseBody Iterable<Person> getAllPerson() {
        return personDao.findAll();
    }
    @GetMapping(path = "{id}")
    public Optional<Person> getPersonById(@PathVariable ("id") Long id) {
        return personDao.findById(id);
    }
   /* @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") Long id){
        personService.deletePerson(id);
    }
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") Long id, @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }*/
}
