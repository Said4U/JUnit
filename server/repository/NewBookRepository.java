package sample.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.server.entity.NewBookEntity;

@Repository
public interface NewBookRepository extends JpaRepository<NewBookEntity, Integer> {
    NewBookEntity findById(int id);
}