package sample.server.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sample.server.entity.ThematicCollectionEntity;
import sample.server.entity.ThematicCollectionEntity;
import sample.server.entity.ThematicCollectionEntity;
import sample.server.entity.ThematicCollectionEntity;
import sample.server.repository.BookRepository;
import sample.server.repository.FavoriteBookRepository;
import sample.server.repository.TakenBookRepository;
import sample.server.repository.ThematicCollectionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ThematicCollectionServiceTest {

    @Autowired
    private ThematicCollectionService thematicCollectionService;
    @MockBean
    private ThematicCollectionRepository thematicCollectionRepository;


    @Test
    void create() {
        ThematicCollectionEntity book = new ThematicCollectionEntity();
        ThematicCollectionEntity expected = new ThematicCollectionEntity();
        expected.setId(1);
        Mockito.when(thematicCollectionRepository.save(book)).thenReturn(expected);
        ThematicCollectionEntity actual = thematicCollectionService.create(book);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void readAll() {
        List<ThematicCollectionEntity> expected = new ArrayList<>();
        Mockito.when(thematicCollectionRepository.findAll()).thenReturn(expected);
        List<ThematicCollectionEntity> book = thematicCollectionService.readAll();
        Assertions.assertEquals(expected, book);
    }

    @Test
    void read() {
        ThematicCollectionEntity book = new ThematicCollectionEntity();
        book.setId(1);
        Optional<ThematicCollectionEntity> expected = Optional.of(book);
        Mockito.when(thematicCollectionRepository.findById(1)).thenReturn(expected);
        Assertions.assertEquals(book, thematicCollectionService.read(1));
    }

    @Test
    void update() {
        ThematicCollectionEntity book = new ThematicCollectionEntity();
        book.setId(1);
        Optional<ThematicCollectionEntity> expected = Optional.of(book);
        Mockito.when(thematicCollectionRepository.findById(1)).thenReturn(expected);
        Assertions.assertTrue(thematicCollectionService.update(book, 1));
    }

    @Test
    void delete() {
        ThematicCollectionEntity book = new ThematicCollectionEntity();
        book.setId(1);
        Optional<ThematicCollectionEntity> expected = Optional.of(book);
        Mockito.when(thematicCollectionRepository.findById(1)).thenReturn(expected);
        Assertions.assertTrue(thematicCollectionService.delete(1));
    }
}