package com.example.springmongo.controller;

import com.example.springmongo.model.book.Book;
import com.example.springmongo.service.books.BookServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/books")
@RestController
public class BookController {

    private final BookServiceImpl bookService;


    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.findAllBooks();
    }

    @PostMapping("/saveBooks")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @GetMapping("/searchKeyword")
    public List<Book> findBooksByKeyword(@RequestParam String keyword){
        return bookService.findBookByName(keyword);
    }
}
