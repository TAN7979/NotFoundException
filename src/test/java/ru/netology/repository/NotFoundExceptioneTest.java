package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NotFoundExceptioneTest {
    Repository repo = new Repository();
    Smartphone smart1 = new Smartphone(1, "Sony 1", 11, "Sony");
    Smartphone smart2 = new Smartphone(2, "LG 2", 21, "LG");
    Smartphone smart3 = new Smartphone(3, "HP 3", 31, "HP");
    Book book4 = new Book(4, "masks", 41, "Metelsky");
    Book book5 = new Book(5, "witchery", 51, "Vasiliev");
    Book book6 = new Book(6, "legacy 1", 61, "Tarmyshev");
    Book book7 = new Book(7, "legacy 2", 71, "Tarmyshev");

    @Test
    public void checkNotFoundException(){
        Repository repo = new Repository();
        repo.save(smart1);
        repo.save(smart2);
        repo.save(smart3);
        repo.save(book4);
        repo.save(book5);
        repo.save(book6);
        repo.save(book7);

        Assertions.assertThrows(NotFoundException.class, ()-> repo.removeById(8));
    }
}
