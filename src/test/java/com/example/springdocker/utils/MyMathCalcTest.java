package com.example.springdocker.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ashkan Amiri
 * Date:  2021-05-14
 * Time:  10:53
 * Project: spring-docker-demo
 * Copyright: MIT
 */
class MyMathCalcTest {
    MyMathCalc m;

    @BeforeEach
    public void init(){
        m = new MyMathCalc();
    }

    @Test
    void addTest() {
        int expected = 2;
        int actual = m.add(1,1);
        assertEquals(expected,actual,"Add method ---> Result should be same");
    }

    @Test
    void multiplyTest() {
        int expected = 6;
        int actual = m.multiply(3,2);
        assertEquals(expected,actual,"Multiply method ---> Result should be same");
    }

    @Test
    void divideTest() {
        int expected = 2;
        double actual = m.divide(4,2);
        assertEquals(expected,actual,"Divide method ---> Result should be same");
    }

    @Test
    void divideTest_givenNollShouldThrowException() {
        assertThrows(ArithmeticException.class,()->m.divide(4,0),"Should throw ArithmeticException");
    }
}