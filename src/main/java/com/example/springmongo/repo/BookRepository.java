package com.example.springmongo.repo;

import com.example.springmongo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {

    List<Book> findByTitleContainingIgnoreCase(String keyword);
}
