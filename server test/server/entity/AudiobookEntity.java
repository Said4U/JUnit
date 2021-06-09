package sample.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "audiobooks")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AudiobookEntity {
    @Id
    @Column(name = "book_id")
    private Integer bookID;

    @Column(name = "reader")
    private String reader;

    @Column(name = "duration")
    private Integer duration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}