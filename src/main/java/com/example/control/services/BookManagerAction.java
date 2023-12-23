package com.example.control.services;

import com.example.control.dtos.BookDTO;
import com.example.control.entities.Book;
import com.example.control.mappers.BookMapper;
import com.example.control.repositories.BookRepository;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookManagerAction implements BookManager{
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<BookDTO> getBookByTitle(String title) {
        List<Book> books = bookRepository.findByTitle(title);
        List<BookDTO> bookDTOS = books.stream().map(bookMapper::fromBookToBookDTO).collect(Collectors.toList());
        return bookDTOS;
    }
    @Override
    public List<BookDTO> getBookByPublisherAndPrice(String publisher, Float price) {
        List<Book> books = bookRepository.findByPublisherAndPrice(publisher, price);
        List<BookDTO> bookDTOS = books.stream().map(bookMapper::fromBookToBookDTO).collect(Collectors.toList());
        return bookDTOS;
    }
    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        // Vérifier si la combinaison de titres et d'éditeur existe déjà
        if (bookRepository.existsByTitleAndPublisher(bookDTO.getTitle(), bookDTO.getPublisher())) {
            // Gérer le cas où la combinaison existe déjà (vous pouvez lancer une exception, retourner null, etc.)
            // Dans cet exemple, je retourne null, mais vous pouvez ajuster cela en fonction de vos besoins.
            return null;
        }

        // Si la combinaison n'existe pas, convertir le DTO en entité et sauvegarder le Book
        Book book = bookMapper.fromBookDTOtoBook(bookDTO);
        book = bookRepository.save(book);

        // Convertir le livre sauvegardé en DTO et le retourner
        return bookMapper.fromBookToBookDTO(book);
    }
    @Override
    public BookDTO deleteBook (Long id ) {
        Book book=bookRepository.findById(id).get();
        bookRepository.delete(book);
        return bookMapper.fromBookToBookDTO(book);
    }
}
