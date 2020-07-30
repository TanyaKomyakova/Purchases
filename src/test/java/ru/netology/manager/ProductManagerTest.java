package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository productRepository= new ProductRepository();
    private ProductManager manager = new ProductManager(productRepository);
    private Product product = new Product();
    private Smartphone first = new Smartphone(1,"version1",12,"LG");
    private Smartphone second = new Smartphone(2,"IpxoneXR",13,"Apple");
    private Smartphone third = new Smartphone(3,"A0",16,"Samsung");
    private Book fourth = new Book(4,"PortraitOfDorianGray",23,"OscarWilde");
    private Book fifth = new Book(5, "OrdinaryStory",17,"IvanAlexandrovichGoncharov");
    private Book sixth = new Book(6, "TheManWhoLaughs",19,"VictorMarieHugo");

    @Test
    public void findASmartphoneByName() {// Следует найти смартфон по названию
        manager.add(first);
        Product[] actual = manager.searchBy("version1");
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findABookByName(){// Следует найти книгу по названию
        manager.add(fourth);
        Product[] actual = manager.searchBy("PortraitOfDorianGray");
        Product[] expected = new Product[]{fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findASmartphoneByManufacturer() {// Следует найти смартфон по производителю
        manager.add(second);
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findABookByAuthor(){// Следует найти книгу по автору
        manager.add(fifth);
        Product[] actual = manager.searchBy("IvanAlexandrovichGoncharov");
        Product[] expected = new Product[]{fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeBookFoundIfDoesNotExist(){// Следует найти книгу по несуществующим данным

        manager.add(sixth);
        manager.matches(product,"version1");
        manager.matches(product,"Apple");
        Product[] actual = manager.searchBy("OscarWilde");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeSmartphoneFoundIfDoesNotExist(){// Следует найти смартфон по несуществующим данным

        manager.add(third);
        manager.matches(product,"version1");
        manager.matches(product,"Apple");
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

}