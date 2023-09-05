package com.example.springmongo.service.shoppingcart;

import com.example.springmongo.model.customer.Customer;
import com.example.springmongo.model.shoppingcart.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShoppingCartService {

    void addToCart(Integer customerId, Integer bookId, int quantity);

    void removeFromCart(Integer customer, Integer id);

    void updateCartItemQuantity(Integer customerId, Integer bookId, int quantity);

    double calculateTotalPrice(Integer customer);

    Customer getCustomerById(Integer customerId);
    List<CartItem> getCustomerCart(Integer customerId);

}
