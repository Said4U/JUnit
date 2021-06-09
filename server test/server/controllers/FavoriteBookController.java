package sample.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.server.entity.FavoriteBookEntity;
import sample.server.service.FavoriteBookService;


import java.util.List;

/**
 * Это класс выполняет функции приема http-запрсоов и их обраотки с помощью класса FavoriteBookService
 * @see FavoriteBookService
 */
@RestController
public class FavoriteBookController {
    private final FavoriteBookService favoriteBookService;

    @Autowired
    public FavoriteBookController(FavoriteBookService favoriteBookService){
        this.favoriteBookService = favoriteBookService;
    }

    @PostMapping(value = "/favoriteBooks")
    public ResponseEntity<?> create(@RequestBody FavoriteBookEntity favoriteBook){
        favoriteBookService.create(favoriteBook);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/favoriteBooks")
    public ResponseEntity<List<FavoriteBookEntity>> read(){
        final List<FavoriteBookEntity> favoriteBooks = favoriteBookService.readAll();
        return favoriteBooks != null && !favoriteBooks.isEmpty() ? new ResponseEntity<>(favoriteBooks, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/favoriteBooks/{id}")
    public  ResponseEntity<FavoriteBookEntity> read(@PathVariable(name="id") int id){
        final FavoriteBookEntity favoriteBook = favoriteBookService.read(id);
        return  favoriteBook != null ? new ResponseEntity<>(favoriteBook, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/favoriteBooks/{id}")
    public ResponseEntity<FavoriteBookEntity> put(@PathVariable(name="id") int id, @RequestBody FavoriteBookEntity newbook){

        if (favoriteBookService.update(newbook, id)){
            FavoriteBookEntity newbookWithId = favoriteBookService.read(id);
            return  new ResponseEntity<>(newbookWithId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/favoriteBooks/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") int id){
        final FavoriteBookEntity favoriteBook = favoriteBookService.read(id);
        if (favoriteBook != null) {
            favoriteBookService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
