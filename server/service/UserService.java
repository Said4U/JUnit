package sample.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.server.entity.UserEntity;
import sample.server.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity create(UserEntity newBook) {
        userRepo.save(newBook);
        return newBook;
    }


    public List<UserEntity> readAll() {
        return new ArrayList<>(userRepo.findAll());
    }


    public UserEntity read(int id) {
        return userRepo.findById(id);
    }


    public boolean update(UserEntity newBook, int id) {
        UserEntity buff = userRepo.findById(id);
        if (buff == null){
            return false;
        }
        newBook.setId(id);
        userRepo.save(newBook);
        return true;
    }

    public boolean delete(int id) {
        UserEntity buff = userRepo.findById(id);
        if (buff != null) {
            userRepo.delete(buff);
            return true;
        }
        return false;
    }
}
