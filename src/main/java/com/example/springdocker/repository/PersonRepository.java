package com.example.springdocker.repository;

import com.example.springdocker.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ashkan Amiri
 * Date:  11/05/2021
 * Time:  11:39
 * Project: spring-docker-demo
 * Copyright: MIT
 */
@Repository
public interface PersonRepository extends MongoRepository<Person, Long> {
}
