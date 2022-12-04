package mk.ukim.finki.veblabs.service.implementation;

import mk.ukim.finki.veblabs.exception.NonExistentUserException;
import mk.ukim.finki.veblabs.model.Order;
import mk.ukim.finki.veblabs.model.ShoppingCart;
import mk.ukim.finki.veblabs.model.User;
import mk.ukim.finki.veblabs.repository.OrderJpaRepository;
import mk.ukim.finki.veblabs.repository.ShoppingCartJpaRepository;
import mk.ukim.finki.veblabs.repository.UserJpaRepository;
import mk.ukim.finki.veblabs.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImplementation implements ShoppingCartService {
    private final ShoppingCartJpaRepository shoppingCartJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final OrderJpaRepository orderJpaRepository;
    public ShoppingCartServiceImplementation(ShoppingCartJpaRepository shoppingCartJpaRepository, UserJpaRepository userJpaRepository, OrderJpaRepository orderJpaRepository) {
        this.shoppingCartJpaRepository = shoppingCartJpaRepository;
        this.userJpaRepository = userJpaRepository;
        this.orderJpaRepository = orderJpaRepository;
    }
    @Override
    public List<Order> getListForUser(String username) throws NonExistentUserException {
        User user = userJpaRepository.findByUsername(username).orElseThrow(NonExistentUserException::new);
        return this.shoppingCartJpaRepository.findByUser(user).getOrders();
    }

    @Override
    public Optional<ShoppingCart> findById(Long id) throws NonExistentUserException {
        return Optional.ofNullable(shoppingCartJpaRepository.findById(id).orElseThrow(NonExistentUserException::new));
    }
}
