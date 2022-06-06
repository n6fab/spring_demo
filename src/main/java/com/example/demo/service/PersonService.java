package com.example.demo.service;

import com.example.demo.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonService {
    public static void main(String[]args) {
        SpringApplication.run(PersonService.class, args);
    }

    public void save(Person n) {
    }
}
