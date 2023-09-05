package com.example.springmongo.model.shoppingcart;
import com.example.springmongo.model.book.Book;
import lombok.Data;

@Data
public class CartItem {

    private Integer id;
    private Book book;
    private int quantity;
}
