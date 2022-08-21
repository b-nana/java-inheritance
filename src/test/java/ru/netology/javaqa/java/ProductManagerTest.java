package ru.netology.javaqa.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ProductManagerTest {

    @Test
    public void shouldAddProduct() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product item1 = new Product(1, "Не книга", 100);
        Product item2 = new Product(2, "Не смартфон", 1000);

        manager.add(item1);
        manager.add(item2);

        Product[] expected = {item1, item2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddBooks() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book1 = new Book(1, "Грозовой перевал", 450, "Эмили Бронте");
        Product book2 = new Book(2, "Поющие в терновнике", 600, "Колин Маккалоу");

        manager.add(book1);
        manager.add(book2);

        Product[] expected = {book1, book2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSmartphones() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product smartphone1 = new Smartphone(1, "IPhone 13 Pro", 100_000, "Apple");
        Product smartphone2 = new Smartphone(2, "Samsung Galaxy S22", 90_000, "Samsung");

        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearch() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product item1 = new Product(1, "Не книга", 100);
        Product item2 = new Smartphone(2, "Samsung Galaxy S22", 90_000, "Samsung");
        Product item3 = new Book(3, "Поющие в терновнике", 600, "Колин Маккалоу");

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Product[] expected = {item2};
        Product[] actual = manager.searchBy("Samsung Galaxy S22");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSearchMultiple() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product item1 = new Product(1, "Не смартфон", 100);
        Product item2 = new Smartphone(2, "Samsung Galaxy S22", 90_000, "Samsung");
        Product item3 = new Smartphone(3, "Samsung Galaxy S22", 100_000, "Samsung");

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Product[] expected = {item3, item2};
        Product[] actual = manager.searchBy("Samsung Galaxy S22");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldFindAll() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product item1 = new Product(1, "Не смартфон", 100);
        Product item2 = new Smartphone(2, "Samsung Galaxy S22", 90_000, "Samsung");
        Product item3 = new Smartphone(3, "Samsung Galaxy S22", 100_000, "Samsung");

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Product[] expected = {item3, item2, item1};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

}

