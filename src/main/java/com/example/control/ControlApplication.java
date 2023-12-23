package com.example.control;

import com.example.control.entities.Book;
import com.example.control.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlApplication.class, args);
    }

    @Bean
    CommandLineRunner start (BookRepository bookRepository) {
        return args -> {
            List<Book> books = List.of(Book.builder()
                    .title("Education")
                    .date_Publication(new Date())
                    .publisher("Hicham Saad")
                    .price(2000.0f)
                    .resume("Book 1 summary")
                    .build(),
                    Book.builder()
                    .title("Education")
                    .date_Publication(new Date())
                    .publisher("Hicham Hassan")
                    .price(2100.0f)
                    .resume("Book 2 summary")
                    .build(),
                    Book.builder()
                    .title("Education")
                    .date_Publication(new Date())
                    .publisher("Hicham Imane")
                    .price(2200.0f)
                    .resume("Book 3 summary")
                    .build(),
                    Book.builder()
                            .title("Education")
                    .date_Publication(new Date())
                    .publisher("Nasreddine Hicham")
                    .price(2300.0f)
                    .resume("Book 4 summary")
                    .build());

            bookRepository.saveAll( books);
        };
    }
}

