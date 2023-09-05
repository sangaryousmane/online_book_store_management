package com.example.springmongo.service;

import com.example.springmongo.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();
    List<Book> findBookByName(String keyword);
    Book saveBook(Book book);
}
