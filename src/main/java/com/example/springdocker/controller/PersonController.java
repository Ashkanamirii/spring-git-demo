package com.example.springdocker.controller;

import com.example.springdocker.model.Person;
import com.example.springdocker.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Ashkan Amiri
 * Date:  11/05/2021
 * Time:  11:39
 * Project: spring-docker-demo
 * Copyright: MIT
 */
@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonService personService;

    @GetMapping("/persons")
    public List<Person> getPerson() {
        return personService.getPerson();
    }

    @PostMapping("/persons")
    public String saveNewPerson(@RequestBody Person person) {
        return personService.saveNewPerson(person);
    }

}
