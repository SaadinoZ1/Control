package com.example.control;

import com.example.control.entities.Book;
import com.example.control.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BookRepository bookRepository) {
        return args -> {
            for (int i = 0; i < 4; i++) {
                Book book = Book.builder()
                        .titre("Education")
                        .date_Publication(new Date())
                        .publisher("Hicham Saad")
                        .Price((float) (i+2000))
                        .resume("")
                        .build();
                bookRepository.save(book);
            }
        };

    }
}
