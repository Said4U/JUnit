package sample.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.server.entity.BookEntity;
import sample.server.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public BookEntity create(BookEntity book) {
        bookRepo.save(book);
        return book;
    }


    
    public List<BookEntity> readAll() {
        return new ArrayList<>(bookRepo.findAll());
    }

    
    public BookEntity read(int id) {
        return bookRepo.findById(id);
    }


    public boolean update(BookEntity book, int id) {
        BookEntity buff = bookRepo.findById(id);
        if (buff == null){
            return false;
        }
        book.setId(id);
        bookRepo.save(book);
        return true;
    }

    public boolean delete(int id) {
        BookEntity buff = bookRepo.findById(id);
        if (buff != null) {
            bookRepo.delete(buff);
            return true;
        }
        return false;
    }
}
