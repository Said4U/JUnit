package sample.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.server.entity.NewBookEntity;
import sample.server.repository.NewBookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewBookService {

    @Autowired
    NewBookRepository newBookRepo;

    public NewBookEntity create(NewBookEntity newBook) {
        newBookRepo.save(newBook);
        return newBook;
    }


    public List<NewBookEntity> readAll() {
        return new ArrayList<>(newBookRepo.findAll());
    }


    public NewBookEntity read(int id) {
        return newBookRepo.findById(id);
    }


    public boolean update(NewBookEntity newBook, int id) {
        NewBookEntity buff = newBookRepo.findById(id);
        if (buff == null){
            return false;
        }
        newBook.setBookID(id);
        newBookRepo.save(newBook);
        return true;
    }

    public boolean delete(int id) {
        NewBookEntity buff = newBookRepo.findById(id);
        if (buff != null) {
            newBookRepo.delete(buff);
            return true;
        }
        return false;
    }
}
