package com.example.control.services;

import com.example.control.dtos.BookDTO;

import java.util.List;

public interface BookManager {
    public List<BookDTO> getBookByTitle(String title);
    public List<BookDTO> getBookByPublisherAndPrice(String publisher, Float price);
    public BookDTO  saveBook(BookDTO bookDTO);
    public BookDTO  deleteBook(Long id);


}
