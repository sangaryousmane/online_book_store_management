package com.example.springmongo.service.shoppingcart;

import com.example.springmongo.exceptions.CustomerNotFoundException;
import com.example.springmongo.exceptions.InvalidQuantityException;
import com.example.springmongo.exceptions.NoBookAvailableInStoreException;
import com.example.springmongo.model.book.Book;
import com.example.springmongo.model.customer.Customer;
import com.example.springmongo.model.shoppingcart.CartItem;
import com.example.springmongo.repo.books.BookRepository;
import com.example.springmongo.repo.customers.CustomersRepository;
import com.example.springmongo.service.books.BookServiceImpl;

import java.util.Optional;

public class ShoppingCartServiceImpl implements ShoppingCartService{

    private final BookServiceImpl bookService;
    private final CustomersRepository customerRepo;

    public ShoppingCartServiceImpl(BookServiceImpl bookService, CustomersRepository customerRepo) {
        this.bookService = bookService;
        this.customerRepo = customerRepo;
    }

     public Customer getCustomerById(Integer customerId){
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
        Book book = bookService.getBookById(bookId);

        if (book == null){
            throw new NoBookAvailableInStoreException("Book not found");
        }
        if (quantity <= 0){
            throw new InvalidQuantityException("Invalid quantity");
        }

        // Add the item to the shopping cart
        CartItem cartItem = findCartItembyBookId(customer, bookId);
        if (cartItem != null){
            cartItem.setQuantity(cartItem.getQuantity());
        }
    }

    // Find the customer cart item based on the book id
    private CartItem findCartItembyBookId(Customer customer, Integer bookId) {
        return customer.getShoppingCart().stream()
                .filter(cartItem -> cartItem.getBook().getId().equals(bookId))
                .findFirst()
                .orElse(null);
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

}
