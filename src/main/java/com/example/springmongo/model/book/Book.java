package com.example.springmongo.model.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor @NoArgsConstructor
@Document(collection = "books")
public class Book {

    @Id
    private Integer id;
    private String title;
    private String description;
    private String authorName;
    private double price;
    private boolean available;

    @Field(name = "book_genre")
    private String genre;
}
