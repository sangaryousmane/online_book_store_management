package com.example.springmongo.controller;

import com.example.springmongo.model.order.Order;
import com.example.springmongo.model.order.OrderItem;
import com.example.springmongo.model.shoppingcart.CartItem;
import com.example.springmongo.service.orders.OrderService;
import com.example.springmongo.service.shoppingcart.ShoppingCartService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/shopping-cart")
@Log4j2
public class ShoppingCartController {

    private final ShoppingCartService shoppingService;
    private final OrderService orderService;

    @Value("${stripe.secretKey}")
    private String stripeSecretKey;
    public ShoppingCartController(ShoppingCartService shoppingService,
                                  OrderService orderService) {
        this.shoppingService = shoppingService;
        this.orderService = orderService;
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
    public String checkout(@RequestParam Integer customerId){
        // Retrieve customer's cart and calculate the total price
        List<CartItem> customerCart = shoppingService.getCustomerCart(customerId);
        double totalPrice = shoppingService.calculateTotalPrice(customerId);
        customerCart.add(new CartItem((int) (totalPrice * 100))); // calculate in cent
        Stripe.apiKey = stripeSecretKey;

        try{
            Map<String, Object> params=new HashMap<>();
            params.put("amount", customerCart.get(2)); // Amount in cents
            params.put("currency", "USD");
            params.put("description", "Book purchased");
            PaymentIntent intent = PaymentIntent.create(params);
            return intent.getClientSecret();
        }catch (StripeException ex){
            log.error("sorry, payment failed");
            ex.printStackTrace();
            return "Payment Failed";
        }
    }

    @GetMapping("/orderHistory/{customerId}")
    public ResponseEntity<List<Order>> getCustomerOrderHistory(@PathVariable Integer customerId){
        return ResponseEntity.ok(orderService.getCustomerOrderHistory(customerId));
    }

}
