package mk.ukim.finki.veblabs.service;

import mk.ukim.finki.veblabs.model.Order;

public interface OrderService {
    Order placeOrder(String balloonColor, String clientName, String address);
}
