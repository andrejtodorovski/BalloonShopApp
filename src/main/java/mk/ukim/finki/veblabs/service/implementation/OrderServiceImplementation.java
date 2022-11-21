package mk.ukim.finki.veblabs.service.implementation;

import mk.ukim.finki.veblabs.model.Order;
import mk.ukim.finki.veblabs.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImplementation implements OrderService {
    @Override
    public Order placeOrder(String balloonColor, String clientName, String address) {
        return new Order(balloonColor,clientName,address);
    }
}
