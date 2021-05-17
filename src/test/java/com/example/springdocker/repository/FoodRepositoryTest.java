package com.example.springdocker.repository;

import com.example.springdocker.model.Food;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.ArrayList;
import java.util.Arrays;
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
class FoodRepositoryTest {

    @Autowired
    FoodRepository foodRepository;

//    @BeforeAll  TODO implement mock here
//    public static void beforeMethod{
//
//    }

    @DisplayName("Test findFoodByCanICookItTest(true) and in this situation false must be empty List")
    @Test
    void findFoodByCanICookItTest() {
        String id = "100";
        String name = "Kebab";
        Food f = new Food("10","Pizza",true,true);
        Food f1 = new Food(id,name, true, true);
        //__________________________________________________________________________//
        List<Food> expectedFoods = Arrays.asList(f, f1);
        foodRepository.saveAll(expectedFoods);
        List<Food> actualFoods = foodRepository.findFoodByCanICookIt(true);
        assertEquals(expectedFoods,actualFoods);
        //__________________________________________________________________________//
        List<Food> actualFoods1 = foodRepository.findFoodByCanICookIt(false);
        assertEquals(new ArrayList<>(),actualFoods1);
        //__________________________________________________________________________//

    }
    @DisplayName("Test findFoodByCanICookItTest(false)")
    @Test
    void findFoodByCanICookItTest1() {
        String id = "100";
        String name = "Kebab";
        Food f = new Food("10","Pizza",true,false);
        Food f1 = new Food(id,name, true, true);
        //__________________________________________________________________________//
        List<Food> foods = Arrays.asList(f,f1);
        foodRepository.saveAll(foods);
        List<Food> expected = new ArrayList<>();
        expected.add(f);
        //__________________________________________________________________________//
        List<Food> actual = foodRepository.findFoodByCanICookIt(false);
        assertEquals(expected,actual);
        //__________________________________________________________________________//
    }
}