package com.example.springmongo.service.orders;

import com.example.springmongo.model.customer.Customer;
import com.example.springmongo.model.order.Order;
import com.example.springmongo.model.order.OrderItem;
import com.example.springmongo.repo.orders.OrderRepository;
import com.example.springmongo.service.shoppingcart.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepo;
    private final ShoppingCartService shoppingCartService;


    public List<Order> getCustomerOrderHistory(Integer customerId) {
        Customer customer = shoppingCartService.getCustomerById(customerId);
        return customer.getOrderHistory();
    }

    // Order creation
    public void createOrder(Integer customerId, List<OrderItem> orderItems, double totalPrice) {
        Customer customer = shoppingCartService.getCustomerById(customerId);

        // Create an order
        Order order = new Order();
        order.setOrderItems(orderItems);
        order.setOrderDate(LocalDateTime.now());

        // Add the order to the customer's order history
        customer.getOrderHistory().add(order);

        // Clear the customer's shopping cart after the order is made
        customer.getShoppingCart().clear();

        // Update the customer in db
        shoppingCartService.updateCustomer(customer);

        // Save the new order
        orderRepo.save(order);
    }


}
