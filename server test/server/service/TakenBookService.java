package sample.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.server.entity.FavoriteBookEntity;
import sample.server.entity.TakenBookEntity;
import sample.server.repository.TakenBookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TakenBookService {

    @Autowired
    TakenBookRepository takenBookRepo;

    public TakenBookEntity create(TakenBookEntity newBook) {
        takenBookRepo.save(newBook);
        return newBook;
    }


    public List<TakenBookEntity> readAll() {
        return new ArrayList<>(takenBookRepo.findAll());
    }


    public TakenBookEntity read(int id) {
        return takenBookRepo.findById(id);
    }


    public boolean update(TakenBookEntity newBook, int id) {
        TakenBookEntity buff = takenBookRepo.findById(id);
        if (buff == null){
            return false;
        }
        newBook.setId(id);
        takenBookRepo.save(newBook);
        return true;
    }

    public boolean delete(int id) {
        TakenBookEntity buff = takenBookRepo.findById(id);
        if (buff != null) {
            takenBookRepo.delete(buff);
            return true;
        }
        return false;
    }

    public boolean deleteByBookID(int id) {
        TakenBookEntity buff = takenBookRepo.findByBookID(id);
        if (buff != null) {
            takenBookRepo.delete(buff);
            return true;
        }
        return false;
    }
}
