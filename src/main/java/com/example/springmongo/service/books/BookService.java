package com.example.springmongo.service.books;

import com.example.springmongo.model.book.Book;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();
    List<Book> findBookByName(String keyword);
    Book saveBook(Book book);
}
