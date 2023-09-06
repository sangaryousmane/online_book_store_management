package com.example.springmongo.model.shoppingcart;

import com.example.springmongo.model.book.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartItem {

    private Integer id;
    private Book book;
    private int quantity;

    public CartItem(int quantity) {
        this.quantity = quantity;
    }
}
