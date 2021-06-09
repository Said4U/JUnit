package sample.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.server.entity.TakenBookEntity;
import sample.server.service.TakenBookService;
import java.util.List;

@RestController
public class TakenBookController {
    private final TakenBookService TakenBookService;

    @Autowired
    public TakenBookController(TakenBookService TakenBookService){
        this.TakenBookService = TakenBookService;
    }

    @PostMapping(value = "/takenBooks")
    public ResponseEntity<?> create(@RequestBody TakenBookEntity newBook){
        TakenBookService.create(newBook);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/takenBooks")
    public ResponseEntity<List<TakenBookEntity>> read(){
        final List<TakenBookEntity> takenBooks = TakenBookService.readAll();
        return takenBooks != null && !takenBooks.isEmpty() ? new ResponseEntity<>(takenBooks, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/takenBooks/{id}")
    public  ResponseEntity<TakenBookEntity> read(@PathVariable(name="id") int id){
        final TakenBookEntity newBook = TakenBookService.read(id);
        return  newBook != null ? new ResponseEntity<>(newBook, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/takenBooks/{id}")
    public ResponseEntity<TakenBookEntity> put(@PathVariable(name="id") int id, @RequestBody TakenBookEntity newbook){

        if (TakenBookService.update(newbook, id)){
            TakenBookEntity newbookWithId = TakenBookService.read(id);
            return  new ResponseEntity<>(newbookWithId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/takenBooks/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") int id){
        final TakenBookEntity newBook = TakenBookService.read(id);
        if (newBook != null) {
            TakenBookService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
