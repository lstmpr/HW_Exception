package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository= new ProductRepository();

    Product first = new Book(1, "The green miles", 560, "King", 413, 1983);
    Product second = new Book(2, "Harry Potter and the Camber of Secrets", 1500, "Rowling", 511, 2003);
    Product third = new Book(3, "Dunno on the Moon", 1000, "Nosov", 140, 1956);
    Product fourth = new TShirt(4, "Reebok", 3000,"White", "50");
    Product fifth = new TShirt(5, "TShirt", 450,"Green", "48");
    Product sixth = new TShirt(6, "Nike", 3500,"Blue", "52");

    @Test
    void shouldRemoveById() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);

        repository.removeById(2);

        Product[] actual = repository.getAll();
        Product[] expected = new Product[] {first, third, fourth, fifth, sixth};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotFoundException() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);

        assertThrows(NotFoundException. class, () -> {
            repository.removeById(8);
        });
    }


}