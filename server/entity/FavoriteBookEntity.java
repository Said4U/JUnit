package sample.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Данный класс явялется сущностью и реализует взаимодействие между кодом и определенной таблицей
 */
@Entity
@Table(name = "favorite_books")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FavoriteBookEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_id")
    private Integer bookID;

    @Column(name = "user_id")
    private Integer userID;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}