package com.example.demo.api;

import com.example.demo.dao.LavoroDao;
import com.example.demo.dao.PersonDao;
import com.example.demo.model.Lavoro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/lavoro")
public class LavoroController {
    @Autowired
    private LavoroDao lavoroDao;
    @Autowired
    private PersonDao personDao;

    @PostMapping
    public @ResponseBody String addLavoro(@RequestBody Lavoro person) {
        Lavoro l = new Lavoro();
        l.setName(person.getName());
        lavoroDao.save(l);
        return "saved";
    }
    @GetMapping
    public @ResponseBody Iterable<Lavoro> getAllLavoro() {
        return lavoroDao.findAll();
    }

    @GetMapping(path = "{id}")
    public Optional<Lavoro> getLavoroById(@PathVariable("id") Long id) {
        return lavoroDao.findById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteLavoroById(@PathVariable("id") Long id) {
        lavoroDao.deleteById(id);
    }

    @PutMapping(path = "/name/{id}")
    public Optional<Lavoro> updatePost(@PathVariable Long id, @RequestBody Lavoro lavoroUpDate) {
        return lavoroDao.findById(id)
                .map(person -> {
                    person.setName(lavoroUpDate.getName());
                    return lavoroDao.save(person);
                });
    }
}