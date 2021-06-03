
package sample.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.server.entity.FavoriteBookEntity;
import sample.server.entity.TakenBookEntity;
import sample.server.entity.UserEntity;

@Repository
public interface TakenBookRepository extends JpaRepository<TakenBookEntity, Integer> {
    TakenBookEntity findById(int id);
    TakenBookEntity findByBookID(int id);

}