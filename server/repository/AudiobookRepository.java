package sample.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.server.entity.AudiobookEntity;

@Repository
public interface AudiobookRepository extends JpaRepository<AudiobookEntity, Integer> {
    AudiobookEntity findById(int id);
}