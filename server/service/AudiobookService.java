package sample.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.server.entity.AudiobookEntity;
import sample.server.repository.AudiobookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AudiobookService {

    @Autowired
    AudiobookRepository AudiobookRepo;

    public AudiobookEntity create(AudiobookEntity book) {
        AudiobookRepo.save(book);
        return book;
    }


    public List<AudiobookEntity> readAll() {
        return new ArrayList<>(AudiobookRepo.findAll());
    }


    public AudiobookEntity read(int id) {
        return AudiobookRepo.findById(id);
    }


    public boolean update(AudiobookEntity book, int id) {
        AudiobookEntity buff = AudiobookRepo.findById(id);
        if (buff == null){
            return false;
        }
        book.setBookID(id);
        AudiobookRepo.save(book);
        return true;
    }

    public boolean delete(int id) {
        AudiobookEntity buff = AudiobookRepo.findById(id);
        if (buff != null) {
            AudiobookRepo.delete(buff);
            return true;
        }
        return false;
    }
}
