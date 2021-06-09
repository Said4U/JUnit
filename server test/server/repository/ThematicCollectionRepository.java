package sample.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.server.entity.TakenBookEntity;
import sample.server.entity.ThematicCollectionEntity;

@Repository
public interface ThematicCollectionRepository extends JpaRepository<ThematicCollectionEntity, Integer> {
    ThematicCollectionEntity findById(int id);
    ThematicCollectionEntity findByBookID(int id);

}