package com.example.springdocker.repository;

import com.example.springdocker.model.Food;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ashkan Amiri
 * Date:  2021-05-15
 * Time:  11:46
 * Project: spring-docker-demo
 * Copyright: MIT
 */
@DataMongoTest
@ExtendWith(SpringExtension.class)
class FoodRepositoryTest {
    List<Food> foods = new ArrayList<>();

    @Autowired
    FoodRepository foodRepository;

    @BeforeEach
    void setUp() {
        String id = "100";
        String name = "Kebab";
         foods.add(new Food("10","Pizza",true,true));
         foods.add(new Food(id,name, true, true));
        foodRepository.saveAll(foods);
    }

    @DisplayName("Test findFoodByCanICookItTest(true) and in this situation false must be empty List")
    @Test
    void findFoodByCanICookItTest() {
        List<Food> expected = foods;
        //__________________________________________________________________________//
        List<Food> actualFoods = foodRepository.findFoodByCanICookIt(true);
        assertEquals(expected,actualFoods);
        //__________________________________________________________________________//
        List<Food> actualFoods1 = foodRepository.findFoodByCanICookIt(false);
        assertEquals(new ArrayList<>(),actualFoods1);
        //__________________________________________________________________________//

    }
    @DisplayName("Test findFoodByCanICookItTest(false)")
    @Test
    void findFoodByCanICookItTest1() {
        List<Food> expected = new ArrayList<>();
        //__________________________________________________________________________//
        List<Food> actual = foodRepository.findFoodByCanICookIt(false);
        assertEquals(expected,actual);
        //__________________________________________________________________________//
    }
}