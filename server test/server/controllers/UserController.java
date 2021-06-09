package sample.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.server.entity.UserEntity;
import sample.server.service.UserService;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody UserEntity newBook){
        userService.create(newBook);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserEntity>> read(){
        final List<UserEntity> users = userService.readAll();
        return users != null && !users.isEmpty() ? new ResponseEntity<>(users, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/users/{id}")
    public  ResponseEntity<UserEntity> read(@PathVariable(name="id") int id){
        final UserEntity newBook = userService.read(id);
        return  newBook != null ? new ResponseEntity<>(newBook, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<UserEntity> put(@PathVariable(name="id") int id, @RequestBody UserEntity newbook){

        if (userService.update(newbook, id)){
            UserEntity newbookWithId = userService.read(id);
            return  new ResponseEntity<>(newbookWithId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") int id){
        final UserEntity newBook = userService.read(id);
        if (newBook != null) {
            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
