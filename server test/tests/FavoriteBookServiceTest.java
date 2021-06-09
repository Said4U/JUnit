package sample.server.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sample.server.entity.FavoriteBookEntity;
import sample.server.entity.FavoriteBookEntity;
import sample.server.repository.BookRepository;
import sample.server.repository.FavoriteBookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FavoriteBookServiceTest {

    @Autowired
    private FavoriteBookService favoriteBookService;
    @MockBean
    private FavoriteBookRepository favoriteBookRepository;


    @Test
    void create() {
        FavoriteBookEntity book = new FavoriteBookEntity();
        FavoriteBookEntity expected = new FavoriteBookEntity();
        expected.setId(1);
        Mockito.when(favoriteBookRepository.save(book)).thenReturn(expected);
        FavoriteBookEntity actual = favoriteBookService.create(book);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void readAll() {
        List<FavoriteBookEntity> expected = new ArrayList<>();
        Mockito.when(favoriteBookRepository.findAll()).thenReturn(expected);
        List<FavoriteBookEntity> book = favoriteBookService.readAll();
        Assertions.assertEquals(expected, book);
    }

    @Test
    void read() {
        FavoriteBookEntity book = new FavoriteBookEntity();
        book.setId(1);
        Optional<FavoriteBookEntity> expected = Optional.of(book);
        Mockito.when(favoriteBookRepository.findById(1)).thenReturn(expected);
        Assertions.assertEquals(book, favoriteBookService.read(1));
    }

    @Test
    void update() {
        FavoriteBookEntity book = new FavoriteBookEntity();
        book.setId(1);
        Optional<FavoriteBookEntity> expected = Optional.of(book);
        Mockito.when(favoriteBookRepository.findById(1)).thenReturn(expected);
        Assertions.assertTrue(favoriteBookService.update(book, 1));
    }

    @Test
    void delete() {
        FavoriteBookEntity book = new FavoriteBookEntity();
        book.setId(1);
        Optional<FavoriteBookEntity> expected = Optional.of(book);
        Mockito.when(favoriteBookRepository.findById(1)).thenReturn(expected);
        Assertions.assertTrue(favoriteBookService.delete(1));
    }
}