package sample.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.server.entity.FavoriteBookEntity;
import sample.server.repository.FavoriteBookRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Данный класс непосредственно взаимодействует с БД. Происходит это при помощи интерфейса, который он реализует.
 * @see FavoriteBookRepository
 */
@Service
public class FavoriteBookService {

    private final FavoriteBookRepository FavoriteBookRepo;

    public FavoriteBookService(FavoriteBookRepository favoriteBookRepo) {
        FavoriteBookRepo = favoriteBookRepo;
    }

    public FavoriteBookEntity create(FavoriteBookEntity newBook) {
        FavoriteBookRepo.save(newBook);
        return newBook;
    }


    public List<FavoriteBookEntity> readAll() {
        return new ArrayList<>(FavoriteBookRepo.findAll());
    }


    public FavoriteBookEntity read(int id) {
        return FavoriteBookRepo.findById(id);
    }


    public boolean update(FavoriteBookEntity newBook, int id) {
        FavoriteBookEntity buff = FavoriteBookRepo.findById(id);
        if (buff == null){
            return false;
        }
        newBook.setId(id);
        FavoriteBookRepo.save(newBook);
        return true;
    }

    public boolean delete(int id) {
        FavoriteBookEntity buff = FavoriteBookRepo.findById(id);
        if (buff != null) {
            FavoriteBookRepo.delete(buff);
            return true;
        }
        return false;
    }

    public boolean deleteByBookID(int id) {
        FavoriteBookEntity buff = FavoriteBookRepo.findByBookID(id);
        if (buff != null) {
            FavoriteBookRepo.delete(buff);
            return true;
        }
        return false;
    }
}

