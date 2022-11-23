package mk.ukim.finki.veblabs.service;

import mk.ukim.finki.veblabs.model.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(String balloonColor, String clientName, String address);
    List<Order> findAll();
    void addOrder(Order order);
}
