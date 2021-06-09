package sample.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.server.entity.FavoriteBookEntity;

/**
 * Данный интерфейс содержит методы, с помощью который можно обращаться к БД
 */
@Repository
public interface FavoriteBookRepository extends JpaRepository<FavoriteBookEntity, Integer> {
    FavoriteBookEntity findById(int id);
    FavoriteBookEntity findByBookID(int id);

}