package com.example.springmongo.model.customer;

import lombok.Data;

@Data
public class Address {

    private String country;
    private String state;
    private String deliveryId;
}
