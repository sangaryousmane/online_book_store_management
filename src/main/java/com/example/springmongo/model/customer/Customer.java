package com.example.springmongo.model.customer;

import com.example.springmongo.model.shoppingcart.CartItem;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "customers")
public class Customer {

    @Id
    private Integer id;
    private String username;
    private String password;
    private Address address;
    private List<CartItem> shoppingCart;
}
