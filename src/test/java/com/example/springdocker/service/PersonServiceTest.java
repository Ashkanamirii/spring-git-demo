package com.example.springdocker.service;

import com.example.springdocker.model.Person;
import com.example.springdocker.repository.FoodRepository;
import com.example.springdocker.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by Ashkan Amiri
 * Date:  2021-05-15
 * Time:  13:51
 * Project: spring-docker-demo
 * Copyright: MIT
 */
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
    PersonService personService;

    @Mock
    PersonRepository repositoryMock;

    @BeforeEach
    public void init() {
        personService = new PersonService(repositoryMock);
    }
    @Test
    void getPersonTest() {
        Person p = new Person(1L, "Ashkan");
        Person p1 = new Person(2L, "Peter");
        List<Person> people = Arrays.asList(p, p1);
        //---------------------------MOCK DATA-------------------------------------
        when(repositoryMock.findAll()).thenReturn(people);
        List<Person> actual = personService.getPerson();
        //-------------------------TEST---------------------------------------
        assertEquals(people,actual);
    }

    @Test
    void saveNewPersonTest() {
        Person p = new Person(1L, "Ashkan");
        //---------------------------MOCK DATA----------------------------
        when(repositoryMock.save(any())).thenReturn(p);
        //----------------------------------------------------------------
        String expected = p.getName() + " has already been saved";
        String actual = personService.saveNewPerson(p);
        //------------------------TEST------------------------------------
        assertEquals(expected,actual);
    }
}