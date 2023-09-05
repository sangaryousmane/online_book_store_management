package com.example.springmongo.service.shoppingcart;

import com.example.springmongo.model.book.Book;
import com.example.springmongo.model.customer.Customer;

public interface ShoppingCartService {

    void addToCart(Integer customerId, Integer bookId, int quantity);

    void removeFromCart(Customer customer, Integer id);
    void updateCartItemQuantity(Customer customer, Integer bookId, int quantity);
    double calculateTotalPrice(Customer customer);

}
