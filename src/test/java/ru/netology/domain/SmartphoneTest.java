package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone smartphone = new Smartphone();
    private Smartphone first = new Smartphone(1,"version1",12,"LG");
    private Smartphone second = new Smartphone(2,"IpxoneXR",13,"Apple");
    private Smartphone third = new Smartphone(3,"A0",16,"Samsung");

    @Test
    public void findByName(){ // Следует найти по имени

        boolean actual = first.matches("version1");
        boolean expected = true;
        assertTrue(actual);
    }

    @Test
    public void findByAuthor(){ // Следует найти по имени производителю

        boolean actual = second.matches("Apple");
        boolean expected = true;
        assertTrue(actual);
    }

    @Test
    public void shouldBeFoundIfDoesNotExist(){ // Следует найти по несуществующему имени

        boolean actual = third.matches("IpxoneXR");
        boolean expected = false;
        assertEquals(actual,expected);
    }


    @Test
    public void shouldBeFoundIfDoesNotExist1(){ // Следует найти по несуществующему производителю

        boolean actual = first.matches("Samsung");
        boolean expected = false;
        assertEquals(actual,expected);
    }




}