package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repository.Repository;

public class RepositoryTest {

    Repository repo = new Repository();
    Smartphone smart1 = new Smartphone(1, "Sony 1", 11, "Sony");
    Smartphone smart2 = new Smartphone(2, "LG 2", 21, "LG");
    Smartphone smart3 = new Smartphone(3, "HP 3", 31, "HP");
    Book book4 = new Book(4, "masks", 41, "Metelsky");
    Book book5 = new Book(5, "witchery", 51, "Vasiliev");
    Book book6 = new Book(6, "legacy", 61, "Tarmyshev");
    @Test
    public void checkRemoveByIdSmart() {

        repo.save(smart1);
        repo.save(smart2);
        repo.save(smart3);
        repo.save(book4);
        repo.save(book5);
        repo.save(book6);
        repo.removeById(smart1.getId());

        Product[] expected = {smart2, smart3, book4, book5, book6};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void checkRemoveByIdBook() {

        repo.save(smart1);
        repo.save(smart2);
        repo.save(smart3);
        repo.save(book4);
        repo.save(book5);
        repo.save(book6);
        repo.removeById(book4.getId());

        Product[] expected = {smart1, smart2, smart3,book5, book6};
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

}

