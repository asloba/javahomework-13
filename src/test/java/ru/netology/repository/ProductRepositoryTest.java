package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book(1, "Идиот", 600, "Ф. М. Достоевский", 545, 1968);
    private Book book2 = new Book(2, "Берег Утопии", 1100, "Т. Стоппард", 920, 2002);
    private Book book3 = new Book(3, "Чума", 400, "А. Камю", 488, 1947);
    private Product tShirt1 = new TShirt(3, "Flower", 660, "Pink", "S");
    private Product tShirt2 = new TShirt(4, "Sea", 700, "Blue", "S");

    @BeforeEach
    void prepare() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(tShirt1);
        repository.save(tShirt2);
    }

    @Test
    public void shouldRemoveById() {

        repository.removeById(2);

        Product[] expected = new Product[]{book1, book3, tShirt1, tShirt2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNull() {

        assertThrows(NotFoundException.class, () -> repository.removeById(6));
    }
}
