package com.example.demo.api;

import com.example.demo.model.Lavoro;
import com.example.demo.model.Person;
import com.example.demo.service.impl.PersonServiceImpl;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {
    @Autowired
    private PersonServiceImpl personService;
    @PostMapping
       public @ResponseBody String addPerson(@RequestBody Person person) {
        personService.save(person);
        return "saved";
    }
   @GetMapping
    public @ResponseBody Iterable<Person> getAllPerson() {
        return personService.findAll();
    }
    @GetMapping(path = "/getId/{id}")
    public Optional<Person> getPersonById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

        /* getNamesByChar */
      @JsonRawValue
        @GetMapping(path = "/getChar/{lettera}")
         public ResponseEntity<String> getNamesByChar(@PathVariable("lettera") Character lettera) {
           var result = personService.findByChar(lettera);
           if (result.isEmpty()) {
               return ResponseEntity.notFound().build();
           }
           StringBuilder sb = new StringBuilder("");
           for (var p:result) {
               sb.append(p.getName()+",");
           }
           return  ResponseEntity.ok(sb.toString());
         }
        /* getLavoroByPersona */
        @JsonRawValue // @ResponseStatus(code=HttpStatus.NOT_FOUND, reason = "FFFFFFFFFFFd")
       @GetMapping(path = "/getLavoroByPersona/{name}")
       public @ResponseBody Optional<Lavoro> getLavoroByPersona(@PathVariable("name") String name) {
        return personService.findByName(name)
        .map(Person::getLavoro);
    }
    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") Long id) {
        personService.deleteById(id);
    }
    @PutMapping(path = "/name/{id}")
    public Optional<Person> updatePost(@PathVariable Long id, @RequestBody Person personUpDate) {
        return personService.findById(id)
                .map(person -> {
                    person.setName(personUpDate.getName());
                    return personService.save(person);
                });
    }
}