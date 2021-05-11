package com.example.springdocker.service;

import com.example.springdocker.model.Person;
import com.example.springdocker.repository.FoodRepository;
import com.example.springdocker.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ashkan Amiri
 * Date:  11/05/2021
 * Time:  11:39
 * Project: spring-docker-demo
 * Copyright: MIT
 */
@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository repository;
    public List<Person> getPerson() {
        return repository.findAll();

    }

    public String saveNewPerson(Person person) {
        repository.save(person);
        return person.getName() + " has already been saved";
    }
}
