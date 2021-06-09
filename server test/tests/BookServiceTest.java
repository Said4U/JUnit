package sample.server.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sample.server.entity.BookEntity;
import sample.server.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;
    @MockBean
    private BookRepository bookRepository;


    @Test
    void create() {
        BookEntity book = new BookEntity();
        BookEntity expected = new BookEntity();
        expected.setId(1);
        Mockito.when(bookRepository.save(book)).thenReturn(expected);
        BookEntity actual = bookService.create(book);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void readAll() {
        List<BookEntity> expected = new ArrayList<>();
        Mockito.when(bookRepository.findAll()).thenReturn(expected);
        List<BookEntity> clients = bookService.readAll();
        Assertions.assertEquals(expected, clients);
    }

    @Test
    void read() {
        BookEntity book = new BookEntity();
        book.setId(1);
        Optional<BookEntity> expected = Optional.of(book);
        Mockito.when(bookRepository.findById(1)).thenReturn(expected);
        Assertions.assertEquals(book, bookService.read(1));
    }

    @Test
    void update() {
        BookEntity book = new BookEntity();
        book.setId(1);
        Optional<BookEntity> expected = Optional.of(book);
        Mockito.when(bookRepository.findById(1)).thenReturn(expected);
        Assertions.assertTrue(bookService.update(book, 1);
    }

    @Test
    void delete() {
        BookEntity book = new BookEntity();
        book.setId(1);
        Optional<BookEntity> expected = Optional.of(book);
        Mockito.when(bookRepository.findById(1)).thenReturn(expected);
        Assertions.assertTrue(bookService.delete(1));
    }
}