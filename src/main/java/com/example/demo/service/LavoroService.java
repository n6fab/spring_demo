package com.example.demo.service;
import com.example.demo.model.Lavoro;
import java.util.Optional;

public interface LavoroService {
    Lavoro save(Lavoro person);
    Optional<Lavoro> findById(Long id);
    void deleteById(Long id);
    Iterable<Lavoro> findAll();
}
