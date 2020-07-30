package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book();
    private Book fourth = new Book(4,"PortraitOfDorianGray",23,"OscarWilde");
    private Book fifth = new Book(5, "OrdinaryStory",17,"IvanAlexandrovichGoncharov");
    private Book sixth = new Book(6, "TheManWhoLaughs",19,"VictorMarieHugo");

    @Test
    public void findByName(){ // Следует найти по имени

        boolean actual = fifth.matches("OrdinaryStory");
        boolean expected = true;
        assertTrue(actual);
    }

    @Test
    public void findByAuthor(){ // Следует найти по имени автору

        boolean actual = fourth.matches("OscarWilde");
        boolean expected = true;
        assertTrue(actual);
    }

    @Test
    public void shouldBeBookFoundIfDoesNotExist(){ // Следует найти по несуществующему имени

        boolean actual = fifth.matches("VictorMarieHugo");
        boolean expected = false;
        assertEquals(actual,expected);
    }


    @Test
    public void shouldBeBookFoundIfDoesNotExist1(){ // Следует найти по несуществующему автору

        boolean actual = sixth.matches("IvanAlexandrovichGoncharov");
        boolean expected = false;
        assertEquals(actual,expected);
    }



}