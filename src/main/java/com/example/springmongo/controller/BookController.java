package com.example.springmongo.controller;

import com.example.springmongo.model.Book;
import com.example.springmongo.repo.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/books")
@RestController
public class BookController {

    private final BookRepository bookRepo;

    public BookController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    @PostMapping("/saveBooks")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return ResponseEntity.ok(bookRepo.save(book));
    }
}
