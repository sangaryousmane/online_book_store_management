package com.example.springmongo.service.shoppingcart;

import com.example.springmongo.model.customer.Customer;
import com.example.springmongo.repo.books.BookRepository;
import com.example.springmongo.repo.customers.CustomersRepository;

import java.util.Optional;

public class ShoppingCartServiceImpl implements ShoppingCartService{

    private final BookRepository bookRepo;
    private final CustomersRepository customerRepo;

    public ShoppingCartServiceImpl(BookRepository bookRepo, CustomersRepository customerRepo) {
        this.bookRepo = bookRepo;
        this.customerRepo = customerRepo;
    }

    private Customer getCustomerById(Integer customerId){
        Optional<Customer> custoId =customerRepo.findById(customerId);

        if (custoId.isPresent()){
            return custoId.get();
        }else{
            throw new CustomerNotFoundException("customer not found");
        }
    }

    @Override
    public void addToCart(Integer customerId, Integer bookId, int quantity) {
        Customer customer = getCustomerById(customerId);
    }

    @Override
    public void removeFromCart(Customer customer, Integer id) {

    }

    @Override
    public void updateCartItemQuantity(Customer customer, Integer bookId, int quantity) {

    }

    @Override
    public double calculateTotalPrice(Customer customer) {
        return 0;
    }

    private final
}
