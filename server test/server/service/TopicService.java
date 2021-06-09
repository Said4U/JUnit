package sample.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.server.entity.TopicEntity;
import sample.server.repository.TopicRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepo;

    public TopicEntity create(TopicEntity newBook) {
        topicRepo.save(newBook);
        return newBook;
    }


    public List<TopicEntity> readAll() {
        return new ArrayList<>(topicRepo.findAll());
    }


    public TopicEntity read(int id) {
        return topicRepo.findById(id);
    }


    public boolean update(TopicEntity newBook, int id) {
        TopicEntity buff = topicRepo.findById(id);
        if (buff == null){
            return false;
        }
        newBook.setId(id);
        topicRepo.save(newBook);
        return true;
    }

    public boolean delete(int id) {
        TopicEntity buff = topicRepo.findById(id);
        if (buff != null) {
            topicRepo.delete(buff);
            return true;
        }
        return false;
    }

    public Integer findByName(String name){
        return topicRepo.findByName(name).getId();

    }
}
