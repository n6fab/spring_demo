package com.example.demo.api;
import com.example.demo.model.Lavoro;
import com.example.demo.service.impl.LavoroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/lavoro")
public class LavoroController {
    @Autowired
    private LavoroServiceImpl lavoroService;
    @PostMapping
    public @ResponseBody String addLavoro(@RequestBody Lavoro person) {
       lavoroService.save(person);
        return "saved";
    }
    @GetMapping
    public @ResponseBody Iterable<Lavoro> getAllLavoro() {
        return lavoroService.findAll();
    }
    @GetMapping(path = "{id}")
    public Optional<Lavoro> getLavoroById(@PathVariable("id") Long id) {
        return lavoroService.findById(id);
    }
    @DeleteMapping(path = "{id}")
    public void deleteLavoroById(@PathVariable("id") Long id) {
        lavoroService.deleteById(id);
    }
    @PutMapping(path = "/name/{id}")
    public Optional<Lavoro> updatePost(@PathVariable Long id, @RequestBody Lavoro lavoroUpDate) {
        return lavoroService.findById(id)
                .map(lavoro -> {
                    lavoro.setName(lavoroUpDate.getName());
                    return lavoroService.save(lavoro);
                });
    }
}