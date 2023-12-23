package com.example.control.repositories;

import com.example.control.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByTitle(String title);

    List<Book> findByPublisherAndPrice(String publisher, Float price);

    boolean existsByTitleAndPublisher(String title, String publisher);
    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Book b WHERE b.title = ?1 AND b.publisher = ?2")
    boolean existsByTitleAndPublisherCustomQuery(String title, String publisher);
}
