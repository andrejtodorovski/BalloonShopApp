package mk.ukim.finki.veblabs.service.implementation;

import mk.ukim.finki.veblabs.model.Order;
import mk.ukim.finki.veblabs.repository.OrderRepository;
import mk.ukim.finki.veblabs.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(String balloonColor, String clientName, String address) {
        return orderRepository.placeOrder(balloonColor,clientName,address);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }
}
