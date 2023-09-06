package com.example.springmongo.model.order;
import com.example.springmongo.model.customer.Customer;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "orders")
public class Order {

    private Integer orderId;
    private LocalDateTime orderDate;
    private Customer customer;
    private List<OrderItem> orderItems;
}
