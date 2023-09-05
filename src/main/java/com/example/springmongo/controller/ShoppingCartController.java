package com.example.springmongo.controller;

import com.example.springmongo.model.shoppingcart.CartItem;
import com.example.springmongo.service.shoppingcart.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingService;

    public ShoppingCartController(ShoppingCartService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @PostMapping("/addToCart")
    public void addToCart(@RequestParam Integer customerId,
                          @RequestParam Integer bookId,
                          int quantity){
        shoppingService.addToCart(customerId, bookId, quantity);
    }

    @DeleteMapping("/removeCartItem")
    public void removeFromCart(@RequestParam Integer customerId, @RequestParam Integer bookId){
        shoppingService.removeFromCart(customerId, bookId);
    }

    @PutMapping("/updateCart")
    public void updateCartItemQuantity(
            @RequestParam Integer customerId,
            @RequestParam Integer bookId,
            @RequestParam int quantity){
        shoppingService.updateCartItemQuantity(customerId, bookId, quantity);
    }

    @GetMapping("/totalPurchased")
    public double calculateTotalPrice(@RequestParam Integer customerId){
        return shoppingService.calculateTotalPrice(customerId);
    }

    @PostMapping("/checkout")
    public void checkout(@RequestParam Integer customerId){
        // Retrieve customer's cart and calculate the total price
        List<CartItem> customerCart = shoppingService.getCustomerCart(customerId);
        double totalPrice = shoppingService.calculateTotalPrice(customerId);

        // checkout will be updated tomorrow
    }

}
