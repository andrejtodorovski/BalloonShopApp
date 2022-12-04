package mk.ukim.finki.veblabs.service;

import mk.ukim.finki.veblabs.exception.NonExistentUserException;
import mk.ukim.finki.veblabs.model.Order;
import mk.ukim.finki.veblabs.model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {
    List<Order> getListForUser(String username) throws NonExistentUserException;
    Optional<ShoppingCart> findById(Long id) throws NonExistentUserException;
}
