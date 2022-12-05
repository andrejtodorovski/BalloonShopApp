package mk.ukim.finki.veblabs.service;

import mk.ukim.finki.veblabs.exception.NonExistentUserException;
import mk.ukim.finki.veblabs.model.Order;
import mk.ukim.finki.veblabs.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    Order placeOrder(String color, String size, String username, LocalDateTime ldt) throws NonExistentUserException;
    List<Order> findAll();
    List<Order> searchByClient(String name) throws NonExistentUserException;
    List<Order> findByDateCreatedBetween(LocalDateTime time1, LocalDateTime time2, User user);
}
