package sample.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.server.entity.TakenBookEntity;
import sample.server.entity.ThematicCollectionEntity;
import sample.server.repository.ThematicCollectionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThematicCollectionService {

    @Autowired
    ThematicCollectionRepository thematicCollectionRepo;

    public ThematicCollectionEntity create(ThematicCollectionEntity newBook) {
        thematicCollectionRepo.save(newBook);
        return newBook;
    }


    public List<ThematicCollectionEntity> readAll() {
        return new ArrayList<>(thematicCollectionRepo.findAll());
    }


    public ThematicCollectionEntity read(int id) {
        return thematicCollectionRepo.findById(id);
    }

    public boolean update(ThematicCollectionEntity newBook, int id) {
        ThematicCollectionEntity buff = thematicCollectionRepo.findById(id);
        if (buff == null){
            return false;
        }
        newBook.setBookID(id);
        thematicCollectionRepo.save(newBook);
        return true;
    }

    public boolean delete(int id) {
        ThematicCollectionEntity buff = thematicCollectionRepo.findById(id);
        if (buff != null) {
            thematicCollectionRepo.delete(buff);
            return true;
        }
        return false;
    }

    public boolean deleteByBookID(int id) {
        ThematicCollectionEntity buff = thematicCollectionRepo.findByBookID(id);
        if (buff != null) {
            thematicCollectionRepo.delete(buff);
            return true;
        }
        return false;
    }
}
