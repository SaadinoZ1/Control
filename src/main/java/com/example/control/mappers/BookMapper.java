package com.example.control.mappers;

import com.example.control.dtos.BookDTO;
import com.example.control.entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public Book fromBookDTOtoBook(BookDTO bookDTO){
        return this.modelMapper.map(bookDTO, Book.class);
    }
    public BookDTO fromBookToBookDTO(Book book){
        return this.modelMapper.map(book, BookDTO.class);
    }
}
