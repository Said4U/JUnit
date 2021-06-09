package sample.server.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sample.server.entity.UserEntity;
import sample.server.entity.UserEntity;
import sample.server.entity.UserEntity;
import sample.server.entity.UserEntity;
import sample.server.repository.BookRepository;
import sample.server.repository.FavoriteBookRepository;
import sample.server.repository.TakenBookRepository;
import sample.server.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;


    @Test
    void create() {
        UserEntity user = new UserEntity();
        UserEntity expected = new UserEntity();
        expected.setId(1);
        Mockito.when(userRepository.save(user)).thenReturn(expected);
        UserEntity actual = userService.create(user);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void readAll() {
        List<UserEntity> expected = new ArrayList<>();
        Mockito.when(userRepository.findAll()).thenReturn(expected);
        List<UserEntity> user = userService.readAll();
        Assertions.assertEquals(expected, user);
    }

    @Test
    void read() {
        UserEntity user = new UserEntity();
        user.setId(1);
        Optional<UserEntity> expected = Optional.of(user);
        Mockito.when(userRepository.findById(1)).thenReturn(expected);
        Assertions.assertEquals(user, userService.read(1));
    }

    @Test
    void update() {
        UserEntity user = new UserEntity();
        user.setId(1);
        Optional<UserEntity> expected = Optional.of(user);
        Mockito.when(userRepository.findById(1)).thenReturn(expected);
        Assertions.assertTrue(userService.update(user, 1));
    }

    @Test
    void delete() {
        UserEntity user = new UserEntity();
        user.setId(1);
        Optional<UserEntity> expected = Optional.of(user);
        Mockito.when(userRepository.findById(1)).thenReturn(expected);
        Assertions.assertTrue(userService.delete(1));
    }
}