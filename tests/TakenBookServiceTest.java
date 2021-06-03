package sample.server.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sample.server.entity.TakenBookEntity;
import sample.server.entity.TakenBookEntity;
import sample.server.entity.TakenBookEntity;
import sample.server.repository.BookRepository;
import sample.server.repository.FavoriteBookRepository;
import sample.server.repository.TakenBookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TakenBookServiceTest {

    @Autowired
    private TakenBookService takenBookService;
    @MockBean
    private TakenBookRepository takenBookRepository;


    @Test
    void create() {
        TakenBookEntity book = new TakenBookEntity();
        TakenBookEntity expected = new TakenBookEntity();
        expected.setId(1);
        Mockito.when(takenBookRepository.save(book)).thenReturn(expected);
        TakenBookEntity actual = takenBookService.create(book);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void readAll() {
        List<TakenBookEntity> expected = new ArrayList<>();
        Mockito.when(takenBookRepository.findAll()).thenReturn(expected);
        List<TakenBookEntity> book = takenBookService.readAll();
        Assertions.assertEquals(expected, book);
    }

    @Test
    void read() {
        TakenBookEntity book = new TakenBookEntity();
        book.setId(1);
        Optional<TakenBookEntity> expected = Optional.of(book);
        Mockito.when(takenBookRepository.findById(1)).thenReturn(expected);
        Assertions.assertEquals(book, takenBookService.read(1));
    }

    @Test
    void update() {
        TakenBookEntity book = new TakenBookEntity();
        book.setId(1);
        Optional<TakenBookEntity> expected = Optional.of(book);
        Mockito.when(takenBookRepository.findById(1)).thenReturn(expected);
        Assertions.assertTrue(takenBookService.update(book, 1));
    }

    @Test
    void delete() {
        TakenBookEntity book = new TakenBookEntity();
        book.setId(1);
        Optional<TakenBookEntity> expected = Optional.of(book);
        Mockito.when(takenBookRepository.findById(1)).thenReturn(expected);
        Assertions.assertTrue(takenBookService.delete(1));
    }
}