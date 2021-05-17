package com.example.springdocker.service;

import com.example.springdocker.model.Food;
import com.example.springdocker.repository.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;


/**
 * Created by Ashkan Amiri
 * Date:  2021-05-15
 * Time:  12:39
 * Project: spring-docker-demo
 * Copyright: MIT
 */
@ExtendWith(MockitoExtension.class)
class FoodServiceTest {

    FoodService foodService;

    @Mock
    FoodRepository repositoryMock;

    @BeforeEach
    public void init() {
        foodService = new FoodService(repositoryMock);
    }

    @Test
    void getFoodsTest() {
        // testing method
        foodService.getFoods();
        verify(repositoryMock).findAll();
    }

    @Test
    void saveNewFoodTest() {
        Food expectedFood = new Food("1", "Pizza", true, true);
        //-----------------------------------------------------//
        when(repositoryMock.save(any())).thenReturn(expectedFood);
        Food actual = foodService.saveNewFood(expectedFood);
        //-----------------------------------------------------//
        verify(repositoryMock).save(isA(Food.class));
        assertEquals(expectedFood, actual);
    }

    @Test
    void getCookableFoodsTest() {
        Food f = new Food("1", "Pizza", true, true);
        Food f1 = new Food("2", "Kebab", true, true);
        List<Food> foodsCanICook = Arrays.asList(f, f1);

        when(repositoryMock.findFoodByCanICookIt(true)).thenReturn((foodsCanICook));
        // EXPECTED
        List<String> expected = foodsCanICook.stream()
                .map(food -> food.getName())
                .collect(Collectors.toList());
        // ACTUAL
        List<String> actual = foodService.getCookableFoods();
        //-----------------------------------------------------------------------------------
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }
}