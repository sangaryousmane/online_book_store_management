package com.example.springmongo.model.order;

import com.example.springmongo.model.book.Book;
import lombok.Data;

@Data
public class OrderItem {

    private Book book;
    private int quantity;
}
