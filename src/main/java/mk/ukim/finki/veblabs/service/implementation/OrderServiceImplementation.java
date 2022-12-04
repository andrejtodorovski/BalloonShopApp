package mk.ukim.finki.veblabs.service.implementation;

import mk.ukim.finki.veblabs.exception.NonExistentUserException;
import mk.ukim.finki.veblabs.model.Order;
import mk.ukim.finki.veblabs.model.User;
import mk.ukim.finki.veblabs.repository.OrderJpaRepository;
import mk.ukim.finki.veblabs.repository.ShoppingCartJpaRepository;
import mk.ukim.finki.veblabs.repository.UserJpaRepository;
import mk.ukim.finki.veblabs.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService {
    private final OrderJpaRepository orderJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final ShoppingCartJpaRepository shoppingCartJpaRepository;
    public OrderServiceImplementation(OrderJpaRepository orderJpaRepository, UserJpaRepository userJpaRepository, ShoppingCartJpaRepository shoppingCartJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
        this.userJpaRepository = userJpaRepository;
        this.shoppingCartJpaRepository = shoppingCartJpaRepository;
    }


    @Override
    public Order placeOrder(String color, String size, String username, LocalDateTime ldt) throws NonExistentUserException {
        User user = userJpaRepository.findByUsername(username).orElseThrow(NonExistentUserException::new);
        Order o = new Order(color,size,user, ldt);
        // shoppingCartJpaRepository.findByUser(user).getOrders().add(o);
        return orderJpaRepository.save(o);
    }

    @Override
    public List<Order> findAll() {
        return orderJpaRepository.findAll();
    }

    @Override
    public List<Order> searchByClient(String name) throws NonExistentUserException {
        User user = userJpaRepository.findByUsername(name).orElseThrow(NonExistentUserException::new);
        return orderJpaRepository.findAllByUser(user);
    }
}
