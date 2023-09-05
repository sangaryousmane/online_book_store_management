package com.example.springmongo.service;

import com.example.springmongo.exceptions.BookIdUniqueConstrainException;
import com.example.springmongo.exceptions.EmptyBookNameNotAllowException;
import com.example.springmongo.exceptions.NoBookAvailableInStoreException;
import com.example.springmongo.model.Book;
import com.example.springmongo.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepo;

    @Override
    public List<Book> findAllBooks() {
        if (bookRepo.findAll().isEmpty()) {
            throw new NoBookAvailableInStoreException("Sorry, no book in store currently");
        }
        log.info("Retrieving books");
        return bookRepo.findAll();
    }

    @Override
    public List<Book> findBookByName(String keyword) {
        if (keyword == null || keyword.equals(" ")) {
            throw new EmptyBookNameNotAllowException("sorry, empty book name not allowed");
        }
        log.info("Retrieving book with names: {}", keyword);
        return bookRepo.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public Book saveBook(Book book) {
        boolean idIsExist = bookRepo.findById(book.getId()).isPresent();
        if (idIsExist) {
            throw new BookIdUniqueConstrainException("Id already exist");
        }
        log.info("saving book: {}", book);
        return bookRepo.save(book);
    }
}
