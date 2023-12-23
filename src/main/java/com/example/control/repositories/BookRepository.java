package com.example.control.repositories;

import com.example.control.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByTitle(String title);

    List<Book> findByPublisherAndPrice(String publisher, Float price);
    boolean existsByTitleAndPublisher(String title, String publisher);

}
