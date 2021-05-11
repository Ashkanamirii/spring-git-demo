package com.example.springdocker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ashkan Amiri
 * Date:  11/05/2021
 * Time:  11:39
 * Project: spring-docker-demo
 * Copyright: MIT
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    Long id;
    String name;
}
